package idv.caemasar.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import idv.caemasar.entity.UploadFile;
import idv.caemasar.service.UploadFileService;

@Action("download")
@Results({ @Result(name = "DOWNLOADRESULT", type = "stream", params = { "inputName", "fileInput", "contentType","\"$(fileType)\"","contentDispostion",
		"filename=\"$(fileName)\"" }) })
public class DownloadAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2488787395149678899L;

	private static Logger logger = LogManager.getLogger(DownloadAction.class);

	@Resource
	private UploadFileService UploadFileService;

	private UploadFile uploadFile;

	private InputStream fileInput;
	private String fileName;

	public String getFileName() {
		return fileName;
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
			uploadFile = UploadFileService.findByName(fileName);
			logger.debug("findByName():::" + uploadFile);
			File file = new File(uploadFile.getUp_filepath());
			logger.debug("toInputStream");
			fileInput = new FileInputStream(file);
			logger.debug("DownloadAction-->E");
			return "DOWNLOADRESULT";
		} catch (Exception e) {
			e.printStackTrace();
			return "DOWNLOADRESULT";
		}

	}

}
