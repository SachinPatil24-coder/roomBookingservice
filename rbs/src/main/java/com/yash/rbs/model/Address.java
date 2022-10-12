package com.yash.rbs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	private String village;
	private String district;
	private String state;
	private String pincode;
	@OneToOne(targetEntity=User.class)  
	private User user;
	public Address() {
		super();
		//TODO Auto-generated constructor stub
	}
	
	public Address(String id, String village, String district, String state, String pincode, User user) {
		super();
		this.id = id;
		this.village = village;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
		this.user = user;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
	
	
	
}
