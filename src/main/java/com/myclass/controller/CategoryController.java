package com.myclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myclass.dto.CategoryDto;
import com.myclass.service.CategoryService;

@Controller
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<CategoryDto> list = categoryService.findAll();
		model.addAttribute("categories", list);
		return "category/category-index";
	}
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("category", new CategoryDto());
		return "category/category-add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPost(ModelMap model, @ModelAttribute("category") CategoryDto category, 
			BindingResult errors) {
		if (errors.hasErrors()) {
			return "category/category-add";
		}
		try {
			categoryService.add(category);
			return "redirect:/category";
		}
		catch (Exception e) {
			model.addAttribute("message", "Thêm mới thất bại");
			return "category/category-add";
		}
	}
	
	@RequestMapping(value = "delete/id",method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		categoryService.delete(id);
		return "redirect:/category";
	}
	
}
