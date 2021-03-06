package com.pinapoll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinapoll.models.Category;
import com.pinapoll.repositories.CategoryRepository;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category getCategory(int id) {
		return null;
	}

	@Override
	public void saveCategory(Category category) {
		
	}

	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getWithName(String name) {
		return categoryRepository.findByName(name);
	}
}
