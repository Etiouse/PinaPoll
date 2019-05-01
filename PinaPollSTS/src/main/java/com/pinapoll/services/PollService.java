package com.pinapoll.services;

import java.util.List;

import com.pinapoll.models.Category;
import com.pinapoll.models.Poll;
import com.pinapoll.models.User;

public interface PollService {

	public Poll getPoll(int id);
	public List<Poll> getPollWithUser(User user);
	public List<Poll> getAll();
	public List<Poll> getPublicPoll();
	public List<Poll> getPollsWithCategory(Category category);
	public List<Poll> getPollsWithQuestion(String question);
	public List<Poll> complexPollsSearch(String question, String categoryName);
	public void savePoll(Poll poll);
	public void deletePoll(Poll poll);
}
