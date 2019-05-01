package com.pinapoll.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "response")
public class Response {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "response_id")
    private Integer id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "checked")
	private Boolean checked;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poll")
	private Poll poll;
	
	@OneToMany(mappedBy = "response", cascade = CascadeType.ALL)
	private List<UserResponse> userResponses;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Poll getPoll() {
		return poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

	public List<UserResponse> getUserResponses() {
		return userResponses;
	}

	public void setUserResponses(List<UserResponse> userResponses) {
		this.userResponses = userResponses;
	}

}
