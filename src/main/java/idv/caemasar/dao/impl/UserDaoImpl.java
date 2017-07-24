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

import idv.caemasar.dao.UserDao;
import idv.caemasar.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	private Logger logger = LogManager.getLogger(UserDaoImpl.class);
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public boolean validateUser(User user) {
		boolean result = false;
		logger.info("UserDaoImpl:::验证-->" + user);
		Session session = sessionFactory.openSession();
		// String hql = "from idv.caemasar.entity.User where username=" +
		// user.getUsername();
		String hql = "from idv.caemasar.entity.User where U_USERNAME = :username";
		Query<User> query = session.createQuery(hql);
		query.setParameter("username", user.getU_username());
		logger.info("query.size:" + query.list().size());
		List<User> resultList = query.getResultList();
		logger.info("resultList.size:" + resultList.size());
		for (User user2 : resultList) {
			logger.info("user from list:" + user2);
			if (user.getU_password().equals(user2.getU_password())) {
				result = true;
				break;
			}
		}
		session.close();
		return result;
	}

	@Override
	public void add(User user) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();

	}

	@Override
	public void delete(User user) {

	}

	@Override
	public void update(User user) {

	}

	@Override
	public User findByName(String username) {

		return null;
	}

	@Override
	public List<User> findAll() {

		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
