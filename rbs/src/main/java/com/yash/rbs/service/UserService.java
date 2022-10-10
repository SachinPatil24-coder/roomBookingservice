package com.yash.rbs.service;

import java.util.List;
import java.util.Optional;

import com.yash.rbs.model.User;
import com.yash.rbs.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	
	public List<User> findAllUser(){
		return userRepo.findAll();
	}
	public Optional<User> userById(Integer id){
		return userRepo.findById(id);	
	}
	
	public User saveUser(User user) {
		User user1=null;
		if(user!=null) {
			user1=userRepo.save(user);
		}
		return user1;
	
	}
}

