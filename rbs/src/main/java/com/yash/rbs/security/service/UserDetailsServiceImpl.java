package com.yash.rbs.security.service;

import javax.transaction.Transactional;

import com.yash.rbs.model.User;
import com.yash.rbs.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepo userRepo;
	

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepo.findByUserName(username).orElseThrow(()->
		new UsernameNotFoundException("User not found with userName "+username));
		return UserDetailsImpl.build(user);
	}

}
