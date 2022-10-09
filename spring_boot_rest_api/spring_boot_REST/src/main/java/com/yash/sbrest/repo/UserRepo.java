package com.yash.sbrest.repo;

import org.springframework.data.repository.CrudRepository;

import com.yash.sbrest.model.User;

public interface UserRepo extends CrudRepository<User, Integer> {

}
