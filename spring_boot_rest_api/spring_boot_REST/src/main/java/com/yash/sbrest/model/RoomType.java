package com.yash.sbrest.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RoomType")
public class RoomType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roomTypeid;	
	private Integer maxCapaity;
	private Double price;
	private String roomType;
	@OneToMany
	private Set<Room> room;
	
	
	
	
	public RoomType(Integer roomTypeid, Integer maxCapaity, Double price, String roomType, Set<Room> room) {
		super();
		this.roomTypeid = roomTypeid;
		this.maxCapaity = maxCapaity;
		this.price = price;
		this.roomType = roomType;
		this.room = room;
	}
	public Integer getRoomTypeid() {
		return roomTypeid;
	}
	public void setRoomTypeid(Integer roomTypeid) {
		this.roomTypeid = roomTypeid;
	}
	public Integer getMaxCapaity() {
		return maxCapaity;
	}
	public void setMaxCapaity(Integer maxCapaity) {
		this.maxCapaity = maxCapaity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Set<Room> getRoom() {
		return room;
	}
	public void setRoom(Set<Room> room) {
		this.room = room;
	}

	
	
}
