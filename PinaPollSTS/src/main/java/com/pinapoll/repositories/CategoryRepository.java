package com.pinapoll.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinapoll.models.Category;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Optional<Category> findById(Integer id);
	Category findByName(String name);
	List<Category> findAll();
}
