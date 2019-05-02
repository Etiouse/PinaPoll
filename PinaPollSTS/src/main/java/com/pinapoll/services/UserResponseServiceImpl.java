package com.pinapoll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinapoll.models.Response;
import com.pinapoll.models.User;
import com.pinapoll.models.UserResponse;
import com.pinapoll.repositories.UserResponseRepository;

@Service("userResponseService")
public class UserResponseServiceImpl implements UserResponseService {
	
	@Autowired
	private UserResponseRepository userResponseRepository;
	
	@Override
	public void saveUserResponse(UserResponse userResponse) {
		userResponseRepository.save(userResponse);
	}

	@Override
	public List<UserResponse> respongetAllResponseWithPollId(int pollId) {
		// TODO Auto-generated method stub
		return userResponseRepository.findByPollId(pollId);
	}
	
	@Override
	public boolean userResponseExist(User user, Response response) {
		return userResponseRepository.findByUserAndPoll(user.getId(), response.getId()) != null;
	}
	
}
