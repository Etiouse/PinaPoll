package com.pinapoll.services;

import org.springframework.stereotype.Service;

import com.pinapoll.models.Category;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

	@Override
	public Category getCategory(int id) {
		return null;
	}

	@Override
	public void saveCategory(Category category) {
		
	}
}
