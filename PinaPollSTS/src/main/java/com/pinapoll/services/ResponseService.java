package com.pinapoll.services;

import java.util.List;

import com.pinapoll.models.Response;

public interface ResponseService {
	
	public List<Response> getResponsesForPoll(int pollId);
	public void saveResponse(Response response);

}
