package com.pinapoll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinapoll.models.UserResponse;

@Repository("userResponseRepository")
public interface UserResponseRepository extends JpaRepository<UserResponse, Integer> {
	
}
