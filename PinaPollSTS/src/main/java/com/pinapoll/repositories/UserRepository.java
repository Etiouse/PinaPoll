package com.pinapoll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinapoll.models.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByName(String name);

}