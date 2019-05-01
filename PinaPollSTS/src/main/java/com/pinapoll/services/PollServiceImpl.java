package com.pinapoll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinapoll.models.Category;
import com.pinapoll.models.Poll;
import com.pinapoll.models.User;
import com.pinapoll.repositories.PollRepository;

@Service("pollService")
public class PollServiceImpl implements PollService {
	
	@Autowired
	private PollRepository pollRepository;

	@Override
	public Poll getPoll(int id) {
		// TODO Auto-generated method stub
		return pollRepository.findById(id).get();
	}
	
	@Override
	public List<Poll> getPollWithUser(User user) {
		// TODO Auto-generated method stub
		return pollRepository.findByUser(user);
	}
	
	@Override
	public List<Poll> getPublicPoll() {
		//return pollRepository.findByIsPublic(pageable)
		return null;
	}

	@Override
	public List<Poll> getPollsWithCategory(Category category) {
		return pollRepository.findByCategory(category);
	}

	@Override
	public List<Poll> getPollsWithQuestion(String question) {
		return pollRepository.findByQuestion(question);
	}

	@Override
	public void savePoll(Poll poll) {
		// TODO Auto-generated method stub
		pollRepository.save(poll);
	}
	
	@Override
	public void deletePoll(Poll poll) {
		pollRepository.delete(poll);
	}

	@Override
	public List<Poll> getAll() {
		return pollRepository.findAll();
	}

}
