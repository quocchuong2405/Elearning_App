package com.myclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myclass.dto.CourseDto;
import com.myclass.dto.TargetDto;
import com.myclass.service.CourseService;
import com.myclass.service.TargetService;

@Controller
@RequestMapping("target")
public class TargetController {
	
	@Autowired
	private TargetService targetService;
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<TargetDto> list = targetService.findAll();
		model.addAttribute("targets", list);
		return "target/target-list";
	}
	
	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("target", new TargetDto());
		 	
		List<CourseDto> list = courseService.findAll();
		model.addAttribute("courses", list);
		return "target/target-add";
	}
	
	@PostMapping("add")
	public String addPost(ModelMap model, @ModelAttribute("target") TargetDto target,
			BindingResult errors) {
		if (errors.hasErrors()) {
			return "target/target-add";
		}
		try {
			targetService.add(target);
			return "redirect:/target";
		}
		
		catch ( Exception e) {
			model.addAttribute("message", "Thêm mới thất bại");
			return "target/target-add";
		}
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		targetService.delelte(id);
		return "redirect:/target";
	}
}
