package com.yash.rbs.restController;


import com.yash.rbs.model.BookedDetails;
import com.yash.rbs.service.ReservedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomBookController {
	
	@Autowired
    ReservedService reservedService;
	
	@PostMapping("/addBookDetails")
	public ResponseEntity bookedRoom(@RequestBody BookedDetails bookedDetails)
	{
		reservedService.bookedRoom(bookedDetails);
		return  ResponseEntity.status(HttpStatus.OK).body("Room books successfully");
	}

}
