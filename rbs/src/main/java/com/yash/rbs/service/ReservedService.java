package com.yash.rbs.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yash.rbs.model.BookedDetails;
import com.yash.rbs.model.Resvered;
import com.yash.rbs.model.RoomAvaiable;
import com.yash.rbs.repository.ReservedRepo;
import com.yash.rbs.repository.RoomAvaiableRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservedService {

	@Autowired
	RoomAvaiableRepo roomAvaiablerepo;
	@Autowired
	ReservedRepo reservedRepo;

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

}
