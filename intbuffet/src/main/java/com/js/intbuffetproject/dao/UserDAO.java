package com.js.intbuffetproject.dao;

import com.js.intbuffetproject.model.User;

public interface UserDAO {

	void addUser(User user);

	void removeUser(User user);
	
	void updateUser(User user);
	
	User getUserByUsername(String username);
	
	
}