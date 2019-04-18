package com.pinapoll.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_category")
    private Integer idCategory;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private List<Poll> polls;
}
