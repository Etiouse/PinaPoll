package com.pinapoll.services;

import java.util.List;

import com.pinapoll.models.Poll;

public interface PollService {

	public Poll getPoll(int id);
	public Poll getPollWithUser(int userId);
	public List<Poll> getAll();
	public List<Poll> getPublicPoll();
	public List<Poll> getPollsWithCategoryId(int categoryId);
	public List<Poll> getPollsWithQuestion(String question);
	public void savePoll(Poll poll);
	
}
