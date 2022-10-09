package com.yash.rbs.repository;

import java.util.List;

import com.yash.rbs.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room, Integer> {

	List<Room> findByRoomNumber(Integer roomNumber);
	
	
	
}
