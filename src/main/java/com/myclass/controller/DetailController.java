package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("details")
public class DetailController {
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String index() {
		return "details/details";
	}
	
}