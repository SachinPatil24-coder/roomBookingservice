package com.yash.rbs.repository;

import com.yash.rbs.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

	User save(String user1);

	String findByEmailId(String user);

}
