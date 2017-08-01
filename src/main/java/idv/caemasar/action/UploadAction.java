package idv.caemasar.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.json.annotations.JSON;

import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionContext;

import idv.caemasar.entity.UploadFile;
import idv.caemasar.service.UploadFileService;

@ParentPackage("json-default")
@Action("upload")
@InterceptorRefs(value = { @InterceptorRef("fileUploadStack") })
@Results({ @Result(name = "UPLOADRESULT", type = "json", params = { "root", "uploadResult" }) })
public class UploadAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3654990021307505728L;

	private static Logger logger = LogManager.getLogger(UploadAction.class);

	@Resource
	private UploadFileService UploadFileService;

	private String uploadResult;

	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	@JSON(name = "uploadResult")
	public String getUploadResult() {
		return uploadResult;
	}

	public void setUploadResult(String uploadResult) {
		this.uploadResult = uploadResult;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	@Override
	public String execute() {
		logger.info("upload::" + upload);
		logger.info("uploadFileName::" + uploadFileName);
		logger.info("uploadContentType::" + uploadContentType);
		String targetDirectory = ServletActionContext.getServletContext().getRealPath("/upload");
		logger.info("targetDirectory::" + targetDirectory);
		String targetFileName = generateFileName(uploadFileName);
		logger.info("targetFileName::" + targetFileName);
		File target = new File(targetDirectory, targetFileName);
		try {
			FileUtils.copyFile(upload, target);
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext()
					.get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);

			// HttpServletRequest request =
			// (HttpServletRequest)ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
			response.setContentType("text/html; charset=utf-8");

			UploadFile uploadFile = new UploadFile(uploadFileName, targetDirectory + targetFileName, new Date());
			if (UploadFileService.addUploadFile(uploadFile)) {
				uploadResult = "SUCCESS";
			}
		} catch (Exception e) {
			logger.info("上传失败::" + e.getMessage());
			uploadResult = "ERROR";
		}
		return "UPLOADRESULT";
	}

	private String generateFileName(String fileName) {
		DateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		String formatDate = format.format(new Date());

		int random = new Random().nextInt(10000);

		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);

		return formatDate + random + extension;
	}

	public void findAll() {
		List<UploadFile> uploadFiles = UploadFileService.findAll();
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext()
				.get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		logger.info("uploadFiles::" + uploadFiles);
		// HttpServletRequest request =
		// (HttpServletRequest)ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		// response.setContentType("text/html; charset=utf-8");
		PrintWriter pw;
		String jsonString;
		try {
			pw = response.getWriter();
			jsonString = JSONArray.toJSONString(uploadFiles);
			logger.info("jsonString::" + jsonString);
			pw.write(jsonString);

			pw.flush();

			pw.close();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

	}
}
