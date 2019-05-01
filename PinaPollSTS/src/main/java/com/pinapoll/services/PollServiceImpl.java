package com.pinapoll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinapoll.models.Poll;
import com.pinapoll.repositories.PollRepository;

@Service("pollService")
public class PollServiceImpl implements PollService {
	
	@Autowired
	PollRepository pollRepository;

	@Override
	public Poll getPoll(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Poll> getPublicPoll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Poll> getPollsWithCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Poll> getPollsWithTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCategory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Poll> getAll() {
		return pollRepository.findAll();
	}
	
	

}
