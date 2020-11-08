package com.myclass.service;

import java.util.List;

import com.myclass.dto.CourseDto;

public interface CourseService {
	List<CourseDto> findAll();
	CourseDto findById(int id);
	void add(CourseDto dto);
	void update(CourseDto dto);
	void delete(int id);
	public List<CourseDto> search(String keyword);
}
 