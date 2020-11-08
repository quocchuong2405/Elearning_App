package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.CategoryDto;
import com.myclass.entity.Category;
import com.myclass.repository.CategoryRepository;
import com.myclass.service.CategoryService;

@Service
@Transactional(rollbackOn = Exception.class)
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<CategoryDto> findAll() {
		List<CategoryDto> dtos = new ArrayList<CategoryDto>();
		
		List<Category> categories = categoryRepository.findAll();
		
		for (Category category : categories) {
			dtos.add(new CategoryDto(category.getId(), category.getTitle(), category.getIcon()));
		}
		return dtos;
	}
	
	@Override
	public CategoryDto findById(int id) {
		Category category = categoryRepository.findById(id).get();
		return new CategoryDto(category.getId(), category.getTitle(), category.getIcon());
	}

	@Override
	public void add(CategoryDto dto) {
		Category category = new Category();
		category.setTitle(dto.getTitle());
		category.setIcon(dto.getIcon());
		
		categoryRepository.save(category);
	}

	@Override
	public void update(CategoryDto dto) {
		Category category = categoryRepository.findById(dto.getId()).get();
		category.setTitle(dto.getTitle());
		category.setIcon(dto.getIcon());
	}

	@Override
	public void delete(int id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public List<CategoryDto> search(String keyword) {
		List<CategoryDto> dtos = new ArrayList<CategoryDto>();
		List<Category> categories = categoryRepository.search(keyword);
		for (Category category : categories) {
			dtos.add(new CategoryDto(category.getId(), category.getTitle(), category.getIcon()));
		}		
			return dtos;
	}
}
