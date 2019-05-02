package com.pinapoll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pinapoll.models.UserResponse;

@Repository("userResponseRepository")
public interface UserResponseRepository extends JpaRepository<UserResponse, Integer> {
	
	@Query(value = "SELECT * FROM user_response WHERE user_id = :userId AND response_id = :responseId", nativeQuery = true)
	UserResponse findByUserAndPoll(@Param("userId")int userId, @Param("responseId")int responseId);
		
}
