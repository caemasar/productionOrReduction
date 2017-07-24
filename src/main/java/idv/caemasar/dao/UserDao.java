package idv.caemasar.dao;

import java.util.List;

import idv.caemasar.entity.User;

public interface UserDao {
	public boolean validateUser(User user);

	public void add(User user);

	public void delete(User user);

	public void update(User user);

	public User findByName(String username);

	public List<User> findAll();
}
