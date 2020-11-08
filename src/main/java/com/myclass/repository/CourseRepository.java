package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Course;
import com.myclass.entity.User;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
//	public List<Course> findAll();
	
//	public List<Course> findById();
	
//	public List<Course> findByName(String name);
	
	@Query("SELECT c FROM Course c WHERE c.title = :keyword OR c.price = :keyword")
	public List<Course> search(@Param("keyword") String keyword);
}
