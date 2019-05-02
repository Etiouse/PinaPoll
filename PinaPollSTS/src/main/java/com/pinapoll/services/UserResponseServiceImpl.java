package com.pinapoll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinapoll.models.UserResponse;
import com.pinapoll.repositories.UserResponseRepository;

@Service("userResponseService")
public class UserResponseServiceImpl {
	
	@Autowired
	private UserResponseRepository userResponseRepository;
	
	public void saveUserResponse(UserResponse userResponse) {
		userResponseRepository.save(userResponse);
	}
	
}
