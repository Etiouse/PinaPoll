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

@Entity
@Table(name = "category")
public class Poll {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "category_id")
    private Integer categoryId;
	
	@Column(name = "is_public")
	private Boolean isPublic;
	
	@Column(name = "closing_date")
	private Date closingDate;
	
	@Column(name = "question")
	private String question;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
}
