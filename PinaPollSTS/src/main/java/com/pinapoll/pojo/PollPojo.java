package com.pinapoll.pojo;

import java.util.Date;
import java.util.List;

import com.pinapoll.models.Category;
import com.pinapoll.models.Response;
import com.pinapoll.models.User;

public class PollPojo {

    private Integer id;

	private User user;
	
	private Boolean isPublic;

	private Date closingDate;

	private Boolean closed;

	private String question;

	private List<Response> responses;

	private Category category;
	
	public String getQuestion(){
		return this.question;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public List<Response> getResponses() {
		return responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
