package com.yash.rbs.service;

import java.util.List;

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
	
	public List<RoomType> findAllRoomType() {
		return roomTypeRepo.findAll();
	}

	public RoomType findRoomType(Integer id) {
		return roomTypeRepo.findByRoomTypeid(id);
	}
	
}

