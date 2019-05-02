package com.pinapoll.pojo;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.pinapoll.models.Poll;
import com.pinapoll.models.Role;
import com.pinapoll.models.UserResponse;

public class UserPojo {
	
	private Integer id;

    private String name;
    
    private String password;

    private String email;
    
	private int active;
    
	private List<Poll> polls;
    
	private List<UserResponse> userResponses;
    
	private Set<Role> roles;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	public int getActive() {
		return active;
	}

	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public void addUserResponse(UserResponse userResponse) {
		userResponses.add(userResponse);
	}
}
