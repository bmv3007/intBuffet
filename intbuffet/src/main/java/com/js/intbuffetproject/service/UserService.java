package com.js.intbuffetproject.service;

import com.js.intbuffetproject.model.User;

/**
 * @see com.js.intbuffetproject.service.impl.UserServiceImpl
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
public interface UserService {

	boolean addUser(User user);

	void updateUser(User user);

	User getUserByUsername(String username);

	void removeUser(User user);

}