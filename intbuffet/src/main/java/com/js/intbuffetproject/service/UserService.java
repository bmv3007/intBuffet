package com.js.intbuffetproject.service;

import com.js.intbuffetproject.model.User;

public interface UserService {

	boolean addUser(User user);

	void editUser(User user);

	User getUserByUsername(String username);

	void removeUser(User user);

}