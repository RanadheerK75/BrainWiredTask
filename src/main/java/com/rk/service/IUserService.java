package com.rk.service;

import java.util.List;

import com.rk.model.User;

public interface IUserService {
	Integer createUser(User user);

	List<User> getAllUser();

	User getOneUser(Integer id);

	void updateUser(User user);

	void deleteUser(Integer id);
}
