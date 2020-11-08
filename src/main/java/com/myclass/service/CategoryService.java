package com.myclass.service;

import java.util.List;

import com.myclass.dto.CategoryDto;

public interface CategoryService {
	List<CategoryDto> findAll();
	CategoryDto findById(int id);
	void add(CategoryDto dto);
	void update(CategoryDto dto);
	void delete(int id);
	public List<CategoryDto> search(String keyword);
}
