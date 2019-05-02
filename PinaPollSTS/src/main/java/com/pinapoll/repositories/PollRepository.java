package com.pinapoll.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pinapoll.models.Category;
import com.pinapoll.models.Poll;
import com.pinapoll.models.User;

@Repository("pollRepository")
public interface PollRepository extends JpaRepository<Poll, Integer> {
	
	Optional<Poll> findById(Integer id);
	
	List<Poll> findByUser(User user);
	
	Page<Poll> findAll(Pageable pageable); 
		
	List<Poll> findByIsPublic(boolean isPublic, Pageable pageable);
	
	List<Poll> findByCategory(Category category);
	
	List<Poll> findByQuestion(String question); // on pourrait faire que il contienne seulement le string, avec une query sql
	
	// TODO :
	
	// find by title and maybe other
	
	
}