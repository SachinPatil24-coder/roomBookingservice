package com.yash.rbs.repository;

import java.util.Optional;

import com.yash.rbs.model.ERole;
import com.yash.rbs.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(ERole name);
}
