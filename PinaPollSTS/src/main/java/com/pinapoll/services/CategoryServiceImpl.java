package com.pinapoll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinapoll.models.Category;
import com.pinapoll.repositories.CategoryRepository;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category getCategory(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCategory(Category category) {
		// TODO Auto-generated method stub
		
	}
}
