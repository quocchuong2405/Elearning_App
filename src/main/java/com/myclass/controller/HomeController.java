package com.myclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myclass.dto.CategoryDto;
import com.myclass.service.CategoryService;
import com.myclass.service.CourseService;
import com.myclass.service.TargetService;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired 
	private TargetService targetService;
	
	
	@GetMapping("")
	public String index(ModelMap model) {
		
		List<CategoryDto> listCategory = categoryService.findAll();
		model.addAttribute("categories", listCategory);
		return "home/index";
	}
}
