package com.yash.rbs.repository;


import com.yash.rbs.model.Resvered;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservedRepo extends JpaRepository<Resvered, Integer> {

}
