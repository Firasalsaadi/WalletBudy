package com.app.walletbuddy.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.walletbuddy.dao.CategoryDAO;
import com.app.walletbuddy.dao.UserDAO;
import com.app.walletbuddy.model.Category;
import com.app.walletbuddy.model.User;

@Service
public class UserServiceImpl implements UserService{

	private UserDAO userDAO; 
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	private CategoryDAO categoryDAO; 
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	private CategoryService categoryService;  
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	@Transactional
	public void addUser(User u) {
		this.userDAO.addUser(u);
	}

	@Override
	@Transactional
	public void updateUser(User u) {
		this.userDAO.updateUser(u);
	}

	@Override
	@Transactional
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		return this.userDAO.getUserById(id);
	}

	@Override
	@Transactional
	public void removeUser(int id) {
		List<Category> userCats = this.categoryService.listCategory(id);
 
		for(Iterator<Category> it = userCats.iterator(); it.hasNext();) {
			Category c = it.next();
			this.categoryService.removeCategory(c.getId());
		}
		
		this.userDAO.removeUser(id);
	}

	@Override
	@Transactional
	public User getUserByCredentials(String email, String password) {
		return this.userDAO.getUserByCredentials(email, password);
	}

}
