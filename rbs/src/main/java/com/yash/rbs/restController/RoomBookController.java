package com.yash.rbs.restController;


import com.yash.rbs.model.BookedDetails;
import com.yash.rbs.model.RoomBookedDetails;
import com.yash.rbs.service.ReservedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins="http://localhost:4200")
public class RoomBookController {
	@Autowired
    ReservedService reservedService;
	
	@PostMapping("/addBookDetails")
	public ResponseEntity bookedRoom(@RequestBody BookedDetails bookedDetails)
	{
		/*
		 * System.out.println(bookedDetails.getCheckIn());
		 * reservedService.bookedRoom(bookedDetails);
		 */
		RoomBookedDetails roomBookedDetails=new RoomBookedDetails();
		roomBookedDetails.setUserID(11);
		roomBookedDetails.setRoomCount(2);
		roomBookedDetails.setRoomNumber("102,103");
		roomBookedDetails.setRoomTypes("Luxury");
		roomBookedDetails.setTotalAmount(200002);
		return  ResponseEntity.status(HttpStatus.OK).body(roomBookedDetails);
	}
}
