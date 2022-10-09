package com.yash.rbs.repository;

import java.util.List;
import java.util.Optional;

import com.yash.rbs.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer>{
	List<User> findByEmailId(String emailId);
	
	Optional<User> findByUserName(String userName);
	
	Boolean existByUserName(String userName);
	
	Boolean existByEmailId(String emailId);
	
}
