package dao;

import java.util.List;

import entity.User;

public interface UserDao {

	void saveUser(User user);
	int deleteUser (int id);
	int updateUser(User user);
	User findById(int id);
	List<User> findAll();
}
