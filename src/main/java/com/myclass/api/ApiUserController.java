package com.myclass.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.UserDto;
import com.myclass.service.UserService;

@RestController
@RequestMapping("api/user")
public class ApiUserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public Object get() {
		List<UserDto> users = userService.findAll();
		return new ResponseEntity<Object>(users, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public Object get(@PathVariable("id") int id) {
		try {
			UserDto user = userService.findById(id);
			return new ResponseEntity<Object>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Không tìm thấy dữ liệu!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("")
	public Object post(@RequestBody UserDto dto) {
		try {
			userService.add(dto);
			return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("")
	public Object put(@RequestBody UserDto dto) {
		try {
			userService.update(dto);
			return new ResponseEntity<String>("Cập nhật thành công!", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Cập nhật thất bại!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") int id) {
		try {
			userService.delete(id);
			return new ResponseEntity<String>("Xóa thành công!", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Xóa thất bại!", HttpStatus.BAD_REQUEST);
		}
	}
}
