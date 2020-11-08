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

import com.myclass.dto.RoleDto;
import com.myclass.dto.UserDto;
import com.myclass.service.RoleService;
import com.myclass.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String index(ModelMap model) {
		//Lấy User list từ db
		List<UserDto> list = userService.findAll();
		// Chuyển tiếp List qua Thymeleaf (user-index.html)
		model.addAttribute("users",list);
		
		return "user/user-index";
	}
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("user", new UserDto());
		
		List<RoleDto> list = roleService.findAll();
		model.addAttribute("roles", list);
		return "user/user-add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPost(ModelMap model, @ModelAttribute("user") UserDto user, 
			BindingResult errors) {
		// NẾU CÓ LỖI XẢY RA, CHUYỂN TIẾP LẠI VỀ TRANG HIỆN TẠI 
				// ĐỂ SHOW LỖI LÊN CHO NGƯỜI DÙNG THẤY
		if (errors.hasErrors()) {
			return "user/user-add";
		}
		try {
			userService.add(user);
			return "redirect:/user";
		}
		catch ( Exception e) {
			model.addAttribute("message", "Thêm mới thất bại");
			return "user/user-add";
		}
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		userService.delete(id);
		return "redirect:/user";
	}
}
