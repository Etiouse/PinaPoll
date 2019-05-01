package com.pinapoll.services;

import java.util.List;

import com.pinapoll.models.Poll;
import com.pinapoll.models.Response;

public interface ResponseService {
	
	public List<Response> getResponsesForPoll(Poll poll);
	public void saveResponse(Response response);

}
