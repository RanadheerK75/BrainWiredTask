package com.rk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.exception.UserNotFoundException;
import com.rk.model.User;
import com.rk.repo.UserRepository;
import com.rk.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository repo;

	@Override
	public Integer createUser(User user) {
		return repo.save(user).getId();
	}

	@Override
	public List<User> getAllUser() {
		return repo.findAll();
	}

	@Override
	public User getOneUser(Integer id) {
		return repo.findById(id).orElseThrow(() -> new UserNotFoundException("User " + id + " Not Exist!!"));
	}

	@Override
	public void updateUser(User user) {
		if(user.getId() == null || !repo.existsById(user.getId())) {
			throw new UserNotFoundException("User Not Exist!!");
		} else {
			repo.save(user);
		}
	}

	@Override
	public void deleteUser(Integer id) {
		repo.delete(getOneUser(id));
	}

}
