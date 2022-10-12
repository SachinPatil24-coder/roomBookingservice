package com.yash.rbs.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yash.rbs.model.BookedDetails;
import com.yash.rbs.model.Resvered;
import com.yash.rbs.model.RoomAvaiable;
import com.yash.rbs.model.RoomType;
import com.yash.rbs.repository.ReservedRepo;
import com.yash.rbs.repository.RoomAvaiableRepo;
import com.yash.rbs.repository.RoomRepo;
import com.yash.rbs.repository.RoomTypeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservedService {


	@Autowired
	RoomAvaiableRepo roomAvaiablerepo;
	@Autowired
	ReservedRepo reservedRepo;
	
	@Autowired
	RoomRepo roomRepo;
	
	@Autowired
	RoomTypeRepo roomTypeRepo;

	public void bookedRoom(BookedDetails bookDetails) {
		// TODO Auto-generated method stub

		String arriveDate = bookDetails.getCheckIn();
		String departureDate = bookDetails.getCheckOut();
		LocalDate start = LocalDate.parse(arriveDate);
		LocalDate end = LocalDate.parse(departureDate);
		LocalDateTime now= LocalDateTime.now();
		Date checkIn = java.sql.Date.valueOf(start);
		Date checkOut = java.sql.Date.valueOf(end);
		List<LocalDate> totalDates = new ArrayList<LocalDate>();
		while (!start.isAfter(end)) {
			totalDates.add(start);
			start = start.plusDays(1);
		}
		RoomAvaiable roomAvaiable = null;
		Integer tempCount=bookDetails.getRoomCount();
		while(tempCount>0)
		{	
			for (LocalDate t : totalDates) {
				System.out.println(t);
				Date date = java.sql.Date.valueOf(t);
				Timestamp today=java.sql.Timestamp.valueOf(now);
				roomAvaiable = roomAvaiablerepo.findByAvaiableDate(date);
				Integer updatedCount = 0;
				if (roomAvaiable.getCount() > 0) {
					updatedCount = roomAvaiable.getCount() - 1;
					allowcateRoom(bookDetails);
					
				}
				roomAvaiable.setCount(updatedCount);
				roomAvaiablerepo.save(roomAvaiable);
				Resvered re = new Resvered();
				re.setCheckIn(checkIn);
				re.setCheckOut(checkOut);
				re.setRoomAvaiable(roomAvaiable);
				re.setBookDate(today);
				re.setTypeId(bookDetails.getTypeId());
				reservedRepo.save(re);
			}
			tempCount--;
		}

	}

	private void allowcateRoom(BookedDetails bookDetails) {
		// TODO Auto-generated method stub
		
		RoomType rooType=roomTypeRepo.findByRoomTypeid(bookDetails.getTypeId());
		//List<Room> room=roomRepo.findByRoomid(bookDetails.getTypeId(), true);
		/*
		 * Room room=roomRepo.findByRoomType(rooType); if(room!=null) {
		 * room.setStatus(false); roomRepo.save(room); } else { throw new
		 * NullPointerException(); }
		 */
		
		/*Room room=roomRepo.findFirstByOrderByRoom_TypeidAsc(bookDetails.getTypeId());
		System.out.println("RRRRRRRRRrr   :::: "+room.getRoomNumber());
		System.out.println("KKKKKKKKKKKKKK ::"+room.getRoomId());*/
		
	}
}
