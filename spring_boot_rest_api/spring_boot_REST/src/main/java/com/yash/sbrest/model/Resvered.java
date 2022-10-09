package com.yash.sbrest.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reserved")
public class Resvered {
	
	@Id @GeneratedValue
	Integer id;
	@Column(name="bookDate")
	Timestamp bookDate;
	@Column(name="checkIn")
	Date checkIn;
	@Column(name="checkOut")
	Date checkOut;
	@Column(name="typeId")
	Integer typeId;
	@ManyToOne
	RoomAvaiable roomAvaiable;
		 
	
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
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
	public RoomAvaiable getRoomAvaiable() {
		return roomAvaiable;
	}
	public void setRoomAvaiable(RoomAvaiable roomAvaiable) {
		this.roomAvaiable = roomAvaiable;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getBookDate() {
		return bookDate;
	}
	public void setBookDate(Timestamp bookDate) {
		this.bookDate = bookDate;
	}
	 
	 
	
	
	

}
