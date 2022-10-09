package com.yash.rbs.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.yash.rbs.model.Room;
import com.yash.rbs.model.RoomDto;
import com.yash.rbs.model.RoomType;
import com.yash.rbs.repository.RoomRepo;
import com.yash.rbs.repository.RoomTypeRepo;
import com.yash.rbs.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

	@Autowired
	RoomRepo roomRepo;

	@Autowired
	RoomTypeRepo roomTypeRepo;

	public List<Room> findAllRoom() {
		return roomRepo.findAll();
	}

	public List<Room> findRoomNumber(Integer roomNumber) {
		return roomRepo.findByRoomNumber(roomNumber);
	}

	public Room saveRoom(RoomDto roomdto) {
		Room room = new Room();
		RoomType roomType = roomTypeRepo.findByRoomTypeid(roomdto.getrType());
		if (roomType != null) {
			room.setRoomNumber(roomdto.getRoomNumber());
			room.setCreatedDate(DateUtil.getCurrentDateTime());
			room.setUpdatedDate(DateUtil.getCurrentDateTime());
			room.setStatus(true);
			room.setRoomType(roomType);
			roomRepo.save(room);
		} else {
			throw new NullPointerException();
		}
		return room;
	}

//	public void saveRoom(RoomDto roomdto) {
//		Room room = new Room();
//		RoomType roomType = roomTypeRepo.findByRoomTypeid(roomdto.getrType());
//		if (roomType != null)
//		{
//			room.setRoomNumber(roomdto.getRoomNumber());
//			// room.setRoomType(roomdto.getRoomType());
//			room.setCreatedDate(roomdto.getCreatedDate());
//			room.setUpdatedDate(roomdto.getUpdatedDate());
//			room.setStatus(roomdto.getStatus());
//			room.setRoomType(roomType);
//		}
//		roomRepo.save(room);
//	}

	
	public Integer delete(Integer roomId) {
		// roomRepo.deleteById(roomId);
		Room room = roomRepo.findById(roomId).get();
		if (room != null) {
			room.setStatus(false);
			roomRepo.save(room);
		} else {
			throw new NullPointerException();
		}
		return roomId;
	}
}
