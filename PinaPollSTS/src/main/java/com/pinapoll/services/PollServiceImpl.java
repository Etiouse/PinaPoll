package com.pinapoll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Poll> getAll(Pageable pageable) {
		return pollRepository.findAll(pageable);
	}

	@Override
	public List<Poll> complexPollsSearch(String question, String categoryName) {
		// TODO Auto-generated method stub

    	System.out.println("question : " +  question + ", category : " + categoryName);
//		if (question == "" && categoryName == "")
		if (question.length() == 0 && categoryName.length() == 0)
		{
	    	System.out.println("both empty");
			return null;
		}
		else if (question.length() != 0 && categoryName.length() != 0)
		{
	    	System.out.println("question : " +  question + ", category : " + categoryName);
			return pollRepository.findByQuestionCategory(question, categoryName);
		}
		else if (question.length() != 0)
		{
	    	System.out.println("question : " +  question);
			return pollRepository.findByQuestionContaining(question);
		}
		else 
		{
	    	System.out.println("category : " + categoryName);
			return pollRepository.findByCategoryName(categoryName);
		}
	}

}
