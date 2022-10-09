package com.yash.sbrest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
@Id
@GeneratedValue
int uid;
String name;
String password;
String address;
String email;
Date checkIn;
Date checkOut;

public Date getCheckIn() {
	return checkIn;
}
public void setCheckIn(Date checkIn) {
	this.checkIn = checkIn;
}
public Date getCheckOut() {
	return checkOut;
}
public void setCheckOut(Date checkOut) {
	this.checkOut = checkOut;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
}
