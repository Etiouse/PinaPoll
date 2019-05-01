package com.pinapoll.services;

import java.util.List;

import com.pinapoll.models.Poll;

public interface PollService {

	public Poll getPoll(int id);
	public List<Poll> getAll();
	public List<Poll> getPublicPoll();
	public List<Poll> getPollsWithCategoryId(int categoryId);
	public List<Poll> getPollsWithTitle(String title);
	public void saveCategory();
	
}
