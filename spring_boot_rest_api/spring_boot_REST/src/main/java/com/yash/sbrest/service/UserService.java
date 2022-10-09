package com.yash.sbrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yash.sbrest.repo.UserRepo;
import com.yash.sbrest.model.*;

@Component
public class UserService {
	@Autowired
	UserRepo urpo;
	
	public List<User> getAllusers()
	{
		List<User> ulist=new ArrayList<>();
		urpo.findAll().forEach(ulist::add);
		
		return ulist;
	}
	public User createUserService(User objuser)
	{
		objuser = urpo.save(objuser);
		return objuser;
	}
	public void delUserByid(Integer id)
	{
		urpo.deleteById(id);
	}
	public User UpdateUserById(User objuser)
	{
		User objuser2 = urpo.save(objuser);
		return objuser;
	}
}
