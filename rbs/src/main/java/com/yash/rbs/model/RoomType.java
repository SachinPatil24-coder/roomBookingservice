package com.yash.rbs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RoomType")
public class RoomType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roomTypeid;	
	private Integer maxCapaity;
	private Double price;
	private String roomTypes;
	
	@OneToMany(mappedBy = "roomType",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Room> room=new HashSet<>();
	
	@OneToMany
	private Set<Resvered> resvered;

	
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

	public String getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(String roomTypes) {
		this.roomTypes = roomTypes;
	}

	public Set<Room> getRoom() {
		return room;
	}

	public void setRoom(Set<Room> room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "RoomType [roomTypeid=" + roomTypeid + ", maxCapaity=" + maxCapaity + ", price=" + price + ", roomTypes="
				+ roomTypes + ", room=" + room + "]";
	}

	
	
	
	
}
