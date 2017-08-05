package com.js.intbuffetproject.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.js.intbuffetproject.dao.UserDAO;
import com.js.intbuffetproject.model.User;
import com.js.intbuffetproject.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	@Override
	public boolean addUser(User user) {
				
		if (getUserByUsername(user.getUsername()) != null) {
			return false;
		} else {
			userDAO.addUser(user);
			return true;
		}

	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);

	}

	@Override
	public User getUserByUsername(String username) {

		return userDAO.getUserByUsername(username);
	}

	@Override
	public void removeUser(User user) {

		userDAO.removeUser(user);

	}

}