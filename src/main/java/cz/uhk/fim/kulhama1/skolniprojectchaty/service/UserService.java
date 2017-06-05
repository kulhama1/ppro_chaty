package cz.uhk.fim.kulhama1.skolniprojectchaty.service;

import cz.uhk.fim.kulhama1.skolniprojectchaty.dao.UserDAO;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserService {

	@Autowired
	       UserDAO userDAO;
	
	@Transactional
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Transactional
	public User getUser(int id) {
		return userDAO.getUser(id);
	}

	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Transactional
	public void updateUser(User user) {
		userDAO.updateUser(user);

	}

	@Transactional
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}
}
