package com.pinapoll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinapoll.models.Response;
import com.pinapoll.repositories.ResponseRepository;

@Service("responseService")
public class ResponseServiceImpl implements ResponseService{

	@Autowired
	private ResponseRepository responseRepository;

	@Override
	public List<Response> getResponsesForPoll(int pollId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveResponse(Response response) {
		// TODO Auto-generated method stub
		
	}
	
}
