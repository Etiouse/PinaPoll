package com.pinapoll.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "*Please provide a name")
    private String name;
    
    @Column(name = "password")
    @NotEmpty(message = "*Please provide a password")
    private String password;
    
    @Column(name = "passwordConfirmation")
    @NotEmpty(message = "*Please provide a password confirmation")
    private String passwordConfirmation;

    @Column(name = "email")
    @NotEmpty(message = "*Please provide an email")
    private String email;
    
    @Column(name = "active")
	private int active;
    
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_response", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_response"))
	private Set<Response> responses;
	
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
	
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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


}