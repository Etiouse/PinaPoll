package com.pinapoll.models;

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

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "poll")
public class Poll {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_poll")
    private Integer idPoll;
	
	@Column(name = "public")
	private Boolean isPublic;
	
	@Column(name = "closing_date")
	private Date closingDate;
	
	@Column(name = "closed")
	private Boolean isClosed;
	
	@Column(name = "question")
	private String question;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "poll")
	private List<Response> responses;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category")
	private Category category;
	
	public String getQuestion(){
		return this.question;
	}
}
