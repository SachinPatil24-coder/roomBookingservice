package com.yash.rbs.restController;

import java.util.List;

import com.yash.rbs.model.Room;
import com.yash.rbs.model.RoomType;
import com.yash.rbs.service.RoomTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RoomTypeController {
	@Autowired
	RoomTypeService roomTypeService;
	
	@PostMapping("/roomType")
	public ResponseEntity<RoomType> saveRoomType(@RequestBody RoomType roomType){
		System.out.println(roomType);
		ResponseEntity<RoomType> response;
		RoomType roomType2 =roomTypeService.saveRoomType(roomType);
		if(roomType2!=null) {
			response=new ResponseEntity<>(HttpStatus.CREATED);
		}else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
		
	}
	
	@GetMapping("/allRoomType")
	public List<RoomType> allRoom() {
		List<RoomType> room = roomTypeService.findAllRoomType();
		ResponseEntity<List<RoomType>> response;
		if (room != null) {
			response = new ResponseEntity<List<RoomType>>(HttpStatus.CREATED);

		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return room;
	}


}
