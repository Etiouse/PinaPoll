package com.pinapoll.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(UserResponseId.class)
@Table(name = "userResponse")
public class UserResponse {
    
	@Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

	@Id
    @ManyToOne
    @JoinColumn(name = "response_id")
    Response response;
	
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
