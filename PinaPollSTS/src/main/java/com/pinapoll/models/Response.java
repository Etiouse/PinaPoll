package com.pinapoll.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "response")
public class Response {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "checked")
	private Boolean checked;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poll")
	private Poll poll;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "responses")
    private Set<User> users;
}
