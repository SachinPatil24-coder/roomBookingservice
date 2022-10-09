package com.yash.rbs.restController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.yash.rbs.model.ERole;
import com.yash.rbs.model.Role;
import com.yash.rbs.model.User;
import com.yash.rbs.repository.RoleRepo;
import com.yash.rbs.repository.UserRepo;
import com.yash.rbs.request.LogInRequest;
import com.yash.rbs.request.SignUpRequest;
import com.yash.rbs.response.JwtResponse;
import com.yash.rbs.response.MessageResponse;
import com.yash.rbs.security.jwt.Jwtutils;
import com.yash.rbs.security.service.UserDetailsImpl;
import com.yash.rbs.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userauth")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepo userRepo;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	RoleRepo roleRepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	Jwtutils jwtutils;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser( @RequestBody LogInRequest logInRequest){
		Authentication authentication=authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(logInRequest.getUserName(), logInRequest.getPassaword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt=jwtutils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetailsImpl=(UserDetailsImpl) authentication.getPrincipal();
		List<String> roles=userDetailsImpl.getAuthorities().stream().map(e->e.getAuthority()).collect(Collectors.toList());
		
		return ResponseEntity.ok(new JwtResponse(jwt, 
				userDetailsImpl.getId(), 
				userDetailsImpl.getFirstName(), 
				userDetailsImpl.getLastName(), 
				userDetailsImpl.getUsername(),
				userDetailsImpl.getEmailId(), 
				roles));
	}
		
	@PostMapping("/signup")
	public ResponseEntity<?> signUpUser(@RequestBody SignUpRequest signUpRequest){
		if(Boolean.TRUE.equals(userRepo.existByUserName(signUpRequest.getUserName()))) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Alert: userName Already Exist..! Please try with another userName"));
		}
		if(Boolean.TRUE.equals(userRepo.existByEmailId(signUpRequest.getEmailId()))) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Alert: EmailId Already Exist..! Please try with another EmailId"));
		}
		
		User user=new User(signUpRequest.getFirstName(), 
				signUpRequest.getLastName(), 
				signUpRequest.getUserName(), 
				signUpRequest.getMobileNo(), signUpRequest.getEmailId(), passwordEncoder.encode(signUpRequest.getPassaword()));
		
		Set<String> strRoles=signUpRequest.getRole();
		Set<Role> roles=new HashSet<>();
		
		if(strRoles==null) {
			Role role=roleRepo.findByName(ERole.ROLE_USER)
					.orElseThrow(()-> new RuntimeException("Alert: UserRole is not found"));
			roles.add(role);
		}else {
			strRoles.forEach(role->{
				if(role.equalsIgnoreCase("admin")) {
					Role adminRole=roleRepo.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(()->new RuntimeException("Alert: UserRole is not found"));
					roles.add(adminRole);
				}else {
					Role userRole=roleRepo.findByName(ERole.ROLE_USER)
							.orElseThrow(()->new RuntimeException("Alert: UserRole is not found"));
					roles.add(userRole);
				}
			}
			
		);
		}
		
		user.setRoles(roles);
		userRepo.save(user);
		
		return ResponseEntity.ok(new MessageResponse("User registered Successfully..!"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	
//	@PostMapping("/booking")
//	public ResponseEntity<User> bookRoom(@Valid @RequestBody User user){
//	User user1=userService.bookRoom(user);
//	ResponseEntity<User> response;
//	if(user1!=null) {
//		response=new ResponseEntity<>(HttpStatus.CREATED);
//	}else {
//		response= new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//	}
//	return  response;
//	}

}
