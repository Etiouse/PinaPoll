package com.pinapoll.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinapoll.models.Poll;

@Repository("pollRepository")
public interface PollRepository extends JpaRepository<Poll, Integer> {
	
	Optional<Poll> findById(Integer id);
	
	Poll findByUser(Integer userId);
	
	List<Poll> findAll(); 
	
	List<Poll> findByIsPublic(boolean isPublic, Pageable pageable);
	
	List<Poll> findByCategory(Integer categoryId);
	
	List<Poll> findByQuestion(String question); // on pourrait faire que il contienne seulement le string, avec une query sql
	
	// TODO :
	
	// find by title and maybe other
	
	
}