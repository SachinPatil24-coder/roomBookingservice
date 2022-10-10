package com.yash.rbs.restController;

import java.util.List;
import java.util.Optional;

import com.yash.rbs.model.AES;
import com.yash.rbs.model.User;
import com.yash.rbs.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/sachin")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	AES securityUtil;
	
	@PostMapping("/booking")
	public ResponseEntity<User> bookRoom(@RequestBody User user){
		//System.out.println(user.getPassaword());
		//System.out.println(securityUtil.encrypt(user.getPassaword()));
	user.setPassaword(securityUtil.encrypt(user.getPassaword()));
	User user1=userService.saveUser(user);
	ResponseEntity<User> response;
	if(user1!=null) {
		response=new ResponseEntity<>(HttpStatus.CREATED);
	}else {
		response= new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	return  response;
	}
	
	@GetMapping("/allUser")
	public ResponseEntity<List<User>> allRoom() {
		List<User> user = userService.findAllUser();
		ResponseEntity<List<User>> response;
		if (user != null) {
			response = new ResponseEntity<List<User>>(user,HttpStatus.CREATED);

		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;

	}

	@RequestMapping(value = "/allUser/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<User>> findByUser(@PathVariable("id") Integer id) {
		Optional<User> user = userService.userById(id);
		if (user.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
