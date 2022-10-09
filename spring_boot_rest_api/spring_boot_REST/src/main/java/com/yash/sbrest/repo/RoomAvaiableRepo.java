package com.yash.sbrest.repo;

import java.util.Date;

import com.yash.sbrest.model.RoomAvaiable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomAvaiableRepo extends JpaRepository<RoomAvaiable, Integer> {

	RoomAvaiable findByAvaiableDate(Date date);
}
