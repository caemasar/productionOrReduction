package idv.caemasar.dao;

import java.util.List;

import idv.caemasar.entity.UploadFile;

public interface UploadFileDao {

	public boolean addUploadFile(UploadFile uploadFile);

	public void add(UploadFile uploadFile);

	public void delete(UploadFile uploadFile);

	public void update(UploadFile uploadFile);

	public UploadFile findByName(String uploadFileName);

	public List<UploadFile> findAll();

}
