package idv.caemasar.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import idv.caemasar.dao.UploadFileDao;
import idv.caemasar.entity.UploadFile;

@Repository
public class UploadFileDaoImpl implements UploadFileDao {
	private Logger logger = LogManager.getLogger(UploadFileDaoImpl.class);
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public boolean addUploadFile(UploadFile uploadFile) {
		logger.info("addUploadFile-->S");
		boolean result = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(uploadFile);
		transaction.commit();
		UploadFile uploadFile2 = findByName(uploadFile.getUp_filename());
		if (uploadFile2 != null) {
			result = true;
		}
		session.close();
		logger.info("addUploadFile<--E");
		return result;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(UploadFile uploadFile) {
		// TODO Auto-generated method stub

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
		logger.info("findByName-->S");
		Session session = sessionFactory.openSession();
		String hql = "from UploadFile where up_filename = :up_filename";
		Query<UploadFile> query = session.createQuery(hql);
		query.setParameter("up_filename", uploadFileName);
		logger.info("query.size:" + query.list().size());
		List<UploadFile> resultList = query.getResultList();
		logger.info("resultList.size:" + resultList.size());
		for (UploadFile uploadFile2 : resultList) {
			logger.info("uploadFile from list:" + uploadFile2);
		}
		session.close();
		logger.info("findByName<--E");
		if (resultList.size() >= 1) {
			return resultList.get(0);
		}
		return null;
	}

	@Override
	public List<UploadFile> findAll() {
		logger.info("findAll-->S");
		Session session = sessionFactory.openSession();
		String hql = "from UploadFile";
		Query<UploadFile> query = session.createQuery(hql);
		logger.info("query.size:" + query.list().size());
		List<UploadFile> resultList = query.getResultList();
		logger.info("resultList.size:" + resultList.size());
		for (UploadFile uploadFile2 : resultList) {
			logger.info("uploadFile from list:" + uploadFile2);
		}
		logger.info("findAll<--E");
		if (resultList.size() > 0) {
			return resultList;
		}
		return null;
	}
}
