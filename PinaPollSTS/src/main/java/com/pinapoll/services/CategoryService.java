package com.pinapoll.services;

import com.pinapoll.models.Category;

public interface CategoryService {
	
	public Category getCategory(int id);
	public void saveCategory(Category category);
	
}
