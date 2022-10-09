package com.yash.rbs.service;

import com.yash.rbs.model.Room;
import com.yash.rbs.model.RoomType;
import com.yash.rbs.repository.RoomTypeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomTypeService {
	
	@Autowired
	RoomTypeRepo roomTypeRepo;
	
	public RoomType saveRoomType(RoomType roomType) {
		return roomTypeRepo.save(roomType);
	}
	

}

