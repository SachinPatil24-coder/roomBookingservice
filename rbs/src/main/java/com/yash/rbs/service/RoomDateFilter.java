package com.yash.rbs.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.yash.rbs.model.RoomAvaiable;
import com.yash.rbs.repository.RoomAvaiableRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomDateFilter implements Filter {
	
	@Autowired
	RoomAvaiableRepo roomAvaiableRepo;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
//		
//		RoomAvaiable lastrow= roomAvaiableRepo.findTopByOrderByIdDesc();
//		System.out.println("ssssssssssss"+lastrow.getAvaiableDate());
//		String str_date=lastrow.getAvaiableDate().toString();
//		String[] array = str_date.split("\\ ");
//		LocalDate now= LocalDate.now();
//		LocalDate target=now.plusDays(10);
//		LocalDate start = LocalDate.parse(array[0]);
//		
//		System.out.println(start);
//		while(!start.isEqual(target))
//		{
//			start = start.plusDays(1);
//			System.out.println(start);
//			RoomAvaiable roomAvaiable=new RoomAvaiable();
//			Date avdate = java.sql.Date.valueOf(start);
//			roomAvaiable.setAvaiableDate(avdate);
//			roomAvaiable.setCount(100);
//			roomAvaiableRepo.save(roomAvaiable);
//		}
//		
		chain.doFilter(request, response);
		
	}

}
