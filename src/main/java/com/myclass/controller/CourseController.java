package com.myclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myclass.dto.CategoryDto;
import com.myclass.dto.CourseDto;
import com.myclass.service.CategoryService;
import com.myclass.service.CourseService;

@Controller
@RequestMapping("course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<CourseDto> list = courseService.findAll();
		model.addAttribute("courses", list);
		return "course/course-list";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("course", new CourseDto());
		
		List<CategoryDto> list = categoryService.findAll();
		model.addAttribute("categories", list);
		
		return "course/course-add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPost(ModelMap model, @ModelAttribute("courses") CourseDto course, 
			BindingResult errors) {
		if (errors.hasErrors()) {
			return "course/course-add";
		}
		try {
			courseService.add(course);
			return "redirect:/course";
		}
		catch (Exception e) {
			model.addAttribute("message", "Thêm mới thất bại");
			return "course/course-add";
		}
	}
	
	@RequestMapping(value = "delete/id",method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		courseService.delete(id);
		return "redirect:/course";
	}
}
