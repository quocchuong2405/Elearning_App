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

import com.myclass.dto.CourseDto;
import com.myclass.dto.VideoDto;
import com.myclass.service.CourseService;
import com.myclass.service.VideoService;

@Controller
@RequestMapping("video")
public class VideoController {
	
	@Autowired
	private VideoService videoService;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("")
	public String index(ModelMap model) {
		List<VideoDto> list = videoService.findAll();
		model.addAttribute("videos", list);

		return "video/video-list";
	}
	
	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("video", new VideoDto());
		List<CourseDto> list = courseService.findAll();
		model.addAttribute("courses", list);
		return "video/video-add";
	}
	
	@PostMapping("add")
	public String addPost(ModelMap model, @ModelAttribute("video") VideoDto video,
			BindingResult errors) {
		if (errors.hasErrors()) {
			return "video/video-add";
		}
		try {
			videoService.add(video);
			return "redirect:/video";
		}
		catch ( Exception e) {
			model.addAttribute("message", "Thêm mới thất bại");
			return "video/video-add";
		}
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") int id) {
		videoService.delete(id);
		return "redirect:/video";
	}
}
