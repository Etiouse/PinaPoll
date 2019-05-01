package com.pinapoll.services;

import java.util.List;

import com.pinapoll.models.Category;

public interface CategoryService {
	
	public Category getCategory(int id);
	public List<Category> getAll();
	public void saveCategory(Category category);
	
}
