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
    @Column(name = "id")
    private Integer id;
	
	@Column(name = "public")
	private Boolean Public;
	
	@Column(name = "closing_date")
	private Date closingDate;
	
	@Column(name = "closed")
	private Boolean closed;
	
	@Column(name = "question")
	private String question;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "poll")
	private List<Response> responses;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category")
	private Category category;
}
