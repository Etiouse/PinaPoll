package com.pinapoll.models;

import java.io.Serializable;

public class UserResponseId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private User user;
	private Response response;
	
	public UserResponseId() {
		
	}
	
	public UserResponseId(User user, Response response) {
		this.user = user;
		this.response = response;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Response getResponse() {
		return response;
	}
	
	public void setResponse(Response response) {
		this.response = response;
	}
}
