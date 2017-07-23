package idv.caemasar.action;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import idv.caemasar.entity.User;
import idv.caemasar.service.UserService;

public class LoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6187702081564532547L;

	private static Logger logger = LogManager.getLogger(LoginAction.class);

	@Resource
	private UserService userService;

	@Override
	public String execute() {
		User user = new User(1, "张三", "123");
		if (validateUser(user)) {
			logger.info("LoginAction::true");
			return SUCCESS;
		} else {
			logger.info("LoginAction::false");
			return SUCCESS;
		}
	}

	public boolean validateUser(User user) {
		return userService.validateUser(user);
	}
}
