package com.yash.sbrest.repo;

import com.yash.sbrest.model.Resvered;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservedRepo extends JpaRepository<Resvered, Integer> {

}
