package com.pinapoll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinapoll.models.Poll;
import com.pinapoll.models.User;
import com.pinapoll.repositories.PollRepository;

import net.bytebuddy.asm.Advice.Return;

@Service("pollService")
public class PollServiceImpl implements PollService {
	
	@Autowired
	private PollRepository pollRepository;

	@Override
	public Poll getPoll(int id) {
		// TODO Auto-generated method stub
		return null;
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
	public List<Poll> getPollsWithCategoryId(int categoryId) {
		return pollRepository.findByCategory(categoryId);
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
	public List<Poll> getAll() {
		return pollRepository.findAll();
	}

}
