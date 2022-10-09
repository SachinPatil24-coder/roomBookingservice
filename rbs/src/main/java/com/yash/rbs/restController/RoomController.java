package com.yash.rbs.restController;

import java.util.List;

import com.yash.rbs.model.Room;
import com.yash.rbs.model.RoomDto;
import com.yash.rbs.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
	@Autowired
	RoomService roomService;

	@PostMapping("/room")
	public ResponseEntity<Room> saveRoom(@RequestBody RoomDto room2) {
		ResponseEntity<Room> response;
		Room room1 = roomService.saveRoom(room2);
		if (room1 != null) {
			response = new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;

	}

	@GetMapping("/allRoom")
	public ResponseEntity<List<Room>> allRoom() {
		List<Room> room = roomService.findAllRoom();
		ResponseEntity<List<Room>> response;
		if (room != null) {
			response = new ResponseEntity<List<Room>>(room,HttpStatus.CREATED);

		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;

	}

	@RequestMapping(value = "/allRoom/{roomNumber}", method = RequestMethod.GET)
	public ResponseEntity<List<Room>> findByNumber(@PathVariable("roomNumber") Integer roomNumber) {
		List<Room> rooms = roomService.findRoomNumber(roomNumber);
		if (rooms.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(rooms, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteRoom/{roomId}")
	public ResponseEntity<Room> deleteRoomId(@PathVariable("roomId") Integer roomId){
		roomService.delete(roomId);
		return new ResponseEntity<Room>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	 
}











