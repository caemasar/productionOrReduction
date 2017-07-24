package idv.caemasar.service;

import java.util.List;

import idv.caemasar.entity.UploadFile;

public interface UploadFileService {

	public boolean addUploadFile(UploadFile uploadFile);
	
	public void delete(UploadFile uploadFile);

	public void update(UploadFile uploadFile);

	public UploadFile findByName(String uploadFileName);

	public List<UploadFile> findAll();
}
