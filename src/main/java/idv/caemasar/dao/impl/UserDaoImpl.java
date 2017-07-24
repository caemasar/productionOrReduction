package idv.caemasar.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import idv.caemasar.dao.UserDao;
import idv.caemasar.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	private Logger logger = LogManager.getLogger(UserDaoImpl.class);

	@Override
	public boolean validateUser(User user) {
		logger.info("UserDaoImpl:::验证-->" + user);
		return true;
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
