package com.yash.rbs.repository;

import com.yash.rbs.model.RoomType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepo extends JpaRepository<RoomType, Integer>{

	RoomType findByRoomTypeid(Integer integer);


}
