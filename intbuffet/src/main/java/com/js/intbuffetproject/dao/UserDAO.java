package com.js.intbuffetproject.dao;

import com.js.intbuffetproject.model.User;

public interface UserDAO {

	public void addUser(User user);

	public void removeUser(String username);
}