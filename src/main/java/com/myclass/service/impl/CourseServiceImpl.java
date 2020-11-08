package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.CourseDto;
import com.myclass.entity.Course;
import com.myclass.repository.CourseRepository;
import com.myclass.service.CourseService;

@Service
@Transactional(rollbackOn = Exception.class)
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public List<CourseDto> findAll() {
		List<CourseDto> dtos = new ArrayList<CourseDto>();
		
		List<Course> courses = courseRepository.findAll();
		for (Course course : courses) {
			dtos.add(new CourseDto(course.getId(), course.getTitle(),
					course.getImage(), course.getLectures_count(),
					course.getHour_count(), course.getLast_update(),
					course.getView_count(), course.getPrice(),
					course.getDiscount(), course.getPromotion_price(),
					course.getDescription(), course.getCategory_id()
					));
		}
		return dtos;
	}

	@Override
	public CourseDto findById(int id) {
		Course course = courseRepository.findById(id).get();
		return new CourseDto(course.getId(), course.getTitle(),
				course.getImage(), course.getLectures_count(),
				course.getHour_count(), course.getLast_update(),
				course.getView_count(), course.getPrice(),
				course.getDiscount(), course.getPromotion_price(),
				course.getDescription(), course.getCategory_id()
				);
	}

	@Override
	public void add(CourseDto dto) {
		Course course = new Course();
		course.setTitle(dto.getTitle());
		course.setImage(dto.getImage());
		course.setLectures_count(dto.getLectures_count());
		course.setHour_count(dto.getHour_count());
		course.setLast_update(dto.getLast_update());
		course.setView_count(dto.getView_count());
		course.setPrice(dto.getPrice());
		course.setDiscount(dto.getDiscount());
		course.setPromotion_price(dto.getPromotion_price());
		course.setDescription(dto.getDescription());
		course.setCategory_id(dto.getCategory_id());
		
		courseRepository.save(course);
	}

	@Override
	public void update(CourseDto dto) {
		Course course = courseRepository.findById(dto.getId()).get();
		course.setTitle(dto.getTitle());
		course.setImage(dto.getImage());
		course.setLectures_count(dto.getLectures_count());
		course.setHour_count(dto.getHour_count());
		course.setLast_update(dto.getLast_update());
		course.setView_count(dto.getView_count());
		course.setPrice(dto.getPrice());
		course.setDiscount(dto.getDiscount());
		course.setPromotion_price(dto.getPromotion_price());
		course.setDescription(dto.getDescription());
		course.setCategory_id(dto.getCategory_id());
		
		courseRepository.save(course);
	}

	@Override
	public void delete(int id) {
		courseRepository.deleteById(id);
		
	}

	@Override
	public List<CourseDto> search(String keyword) {
		List<CourseDto> dtos = new ArrayList<CourseDto>();
		List<Course> courses = courseRepository.search(keyword);
		for (Course course : courses) {
			dtos.add(new CourseDto(course.getId(), course.getTitle(),
				course.getImage(), course.getLectures_count(),
				course.getHour_count(), course.getLast_update(),
				course.getView_count(), course.getPrice(),
				course.getDiscount(), course.getPromotion_price(),
				course.getDescription(), course.getCategory_id()
				));
		}
		return dtos;
	}

}
