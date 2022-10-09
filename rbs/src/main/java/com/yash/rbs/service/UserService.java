package com.yash.rbs.service;

import com.yash.rbs.model.User;
import com.yash.rbs.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	
	public User bookRoom(User user) {
		return userRepo.save(user);
	}
	
	
	
}
