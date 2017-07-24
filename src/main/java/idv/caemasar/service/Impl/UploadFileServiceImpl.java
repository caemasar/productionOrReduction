package idv.caemasar.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import idv.caemasar.dao.UploadFileDao;
import idv.caemasar.entity.UploadFile;
import idv.caemasar.service.UploadFileService;

@Service
public class UploadFileServiceImpl implements UploadFileService {
	private Logger logger = LogManager.getLogger(UploadFileServiceImpl.class);

	@Resource
	private UploadFileDao uploadFileDao;

	@Override
	public boolean addUploadFile(UploadFile uploadFile) {
		logger.info("UploadFileServiceImpl:::添加-->" + uploadFile);
		return uploadFileDao.addUploadFile(uploadFile);
	}

	@Override
	public void delete(UploadFile uploadFile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UploadFile uploadFile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UploadFile findByName(String uploadFileName) {
		logger.info("UploadFileServiceImpl:::查找-->" + uploadFileName);
		return uploadFileDao.findByName(uploadFileName);
	}

	@Override
	public List<UploadFile> findAll() {
		logger.info("UploadFileServiceImpl:::查找全部-->");
		return uploadFileDao.findAll();
	}

}
