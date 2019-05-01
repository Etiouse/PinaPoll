package com.pinapoll.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinapoll.models.Poll;

@Repository("pollRepository")
public interface PollRepository extends JpaRepository<Poll, Integer> {
	
	Poll findById(Integer id); // TODO : paginate
	
	List<Poll> findByCategory(Integer id);
	
}