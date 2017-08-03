package idv.caemasar.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import idv.caemasar.entity.UploadFile;
import idv.caemasar.service.UploadFileService;
import redis.clients.jedis.Jedis;

@Action(results = {
		@Result(name = "DOWNLOADRESULT", type = "stream", params = { "inputName", "fileInput", "contentType",
				"${fileType}", "contentDispostion", "attachment;filename=\"${fileName}\"", "bufferSize", "4096" }) })
public class DownloadAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2488787395149678899L;

	private static Logger logger = LogManager.getLogger(DownloadAction.class);

	@Resource
	private UploadFileService UploadFileService;

	// private RedisService rs = RedisTool.getRedisService();

	private UploadFile uploadFile;

	private InputStream fileInput;
	private String fileName;
	private String fileType;

	public String getFileType() throws UnsupportedEncodingException {
		// fileType = "k" + getFileName().substring(fileName.lastIndexOf("."));
		// if (rs != null) {
		// fileType = rs.get(fileType);
		// }
		return new String(fileType.getBytes(), "ISO8859-1");
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileName() throws UnsupportedEncodingException {
		// fileName =
		// ServletActionContext.getRequest().getParameter("fileName");
		return new String(fileName.getBytes(), "ISO8859-1");
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getFileInput() {
		try {
			return new FileInputStream(new File(uploadFile.getUp_filepath()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setFileInput(InputStream fileInput) {
		this.fileInput = fileInput;
	}

	public String execute() throws Exception {
		try {
			logger.debug("DownloadAction-->S");
			logger.debug("fileName1:::" + fileName);
			fileName = ServletActionContext.getRequest().getParameter("fileName");
			logger.debug("fileName2:::" + fileName);
			fileType = "k" + fileName.substring(fileName.lastIndexOf("."));
			logger.debug("fileType1:::" + fileType);
			// 连接本地的 Redis 服务
			Jedis jedis = new Jedis("localhost");
			logger.debug("连接成功");
			// 查看服务是否运行
			logger.debug("服务正在运行: " + jedis.ping());
			// if (rs != null) {
			// logger.debug("RedisService : " + rs);
			ServletContext context = ServletActionContext.getServletContext();
			fileType = context.getMimeType(fileName);
			// fileType = jedis.get(fileType);
			// }
			logger.debug("fileType2:::" + fileType);
			uploadFile = UploadFileService.findByName(fileName);
			logger.debug("findByName():::" + uploadFile);
			File file = new File(uploadFile.getUp_filepath());
			logger.debug("toInputStream");
			fileInput = new BufferedInputStream(new FileInputStream(file));
			logger.debug("DownloadAction-->E");
			return "DOWNLOADRESULT";
		} catch (Exception e) {
			e.printStackTrace();
			return "DOWNLOADRESULT";
		}

	}

}
