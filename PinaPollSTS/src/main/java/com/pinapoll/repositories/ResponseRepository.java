package com.pinapoll.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pinapoll.models.Poll;
import com.pinapoll.models.Response;

@Repository("responseRepository")
public interface ResponseRepository extends JpaRepository<Response, Integer> {
	
	List<Response> findByPoll(Poll poll);
	
	//@Query("SELECT u.tags FROM User u WHERE u.id = :id") // TODO
	//List<Response> findUserResponseForPoll(@Param("user_id") int userId, @Param("poll_id") int pollId);
	
	List<Response> findByUser_Responses(Integer id_response);
}
