package com.pinapoll.services;

import com.pinapoll.models.Poll;
import com.pinapoll.models.Response;
import com.pinapoll.models.User;
import com.pinapoll.models.UserResponse;

public interface UserResponseService {
	
	public boolean userResponseExist(User user, Response response);
	
	public void saveUserResponse(UserResponse userResponse);
	
}
