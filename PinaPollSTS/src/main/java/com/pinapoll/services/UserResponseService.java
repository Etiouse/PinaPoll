package com.pinapoll.services;

import java.util.List;

import com.pinapoll.models.UserResponse;

public interface UserResponseService {
	
	public void saveUserResponse(UserResponse userResponse);
	public List<UserResponse> respongetAllResponseWithPollId(int pollId);
}
