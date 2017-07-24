package idv.caemasar.service.Impl;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import idv.caemasar.dao.UserDao;
import idv.caemasar.entity.User;
import idv.caemasar.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Resource
	private UserDao userDao;

	@Override
	public boolean validateUser(User user) {
		logger.info("UserServiceImpl:::验证-->" + user);
		return userDao.validateUser(user);
	}

}
