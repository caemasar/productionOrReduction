package idv.caemasar.action;

import java.io.File;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Action("upload")
@InterceptorRefs(value = { @InterceptorRef("fileUploadStack") })
@Results({ @Result(name = "success", location = "/index.jsp") })
public class UploadAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3654990021307505728L;

	private static Logger logger = LogManager.getLogger(UploadAction.class);

	private File upload;
	private String uploadFileName;
	private String uploadContentType;

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
	public String execute() throws Exception {
		logger.info("upload::" + upload);
		logger.info("uploadFileName::" + uploadFileName);
		logger.info("uploadContentType::" + uploadContentType);
		String targetDirectory = ServletActionContext.getServletContext().getRealPath("/upload");
		logger.info("targetDirectory::" + targetDirectory);
		String targetFileName = generateFileName(uploadFileName);
		logger.info("targetFileName::" + targetFileName);
		File target = new File(targetDirectory, targetFileName);
		System.out.println("uploadFile::" + upload);
		System.out.println("uploadFileName::" + uploadFileName);
		System.out.println("uploadContentType::" + uploadContentType);
		System.out.println("targetDirectory::" + targetDirectory);
		System.out.println("targetFileName::" + targetFileName);
		FileUtils.copyFile(upload, target);
		return "success";
	}

	private String generateFileName(String fileName) {
		DateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		String formatDate = format.format(new Date());

		int random = new Random().nextInt(10000);

		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);

		return formatDate + random + extension;
	}

}
