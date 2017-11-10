package com.app.walletbuddy.service;

import java.util.List;

import com.app.walletbuddy.model.User;


public interface UserService {

	public void addUser(User u);
	public void updateUser(User u);
	public List<User> listUsers();
	public User getUserById(int id);
	public User getUserByCredentials(String email, String password);
	public void removeUser(int id);
	
}
