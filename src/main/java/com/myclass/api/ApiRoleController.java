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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.RoleDto;
import com.myclass.service.RoleService;

@RestController
@RequestMapping("api/role")
public class ApiRoleController {
	
	@Autowired
	private RoleService roleService;

	@GetMapping("")
	public Object get() {
		List<RoleDto> roles = roleService.findAll();
		return new ResponseEntity<Object>(roles, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public Object get(@PathVariable("id") int id) {
		try {
			RoleDto role = roleService.findById(id);
			return new ResponseEntity<Object>(role, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Không tìm thấy dữ liệu!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("")
	public Object post(@RequestBody RoleDto dto) {
		try {
			roleService.add(dto);
			return new ResponseEntity<String>("Thêm thành công!", HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Thêm thất bại!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("")
	public Object put(@RequestBody RoleDto dto) {
		try {
			roleService.update(dto);
			return new ResponseEntity<String>("Cập nhật thành công!", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Cập nhật thất bại!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") int id) {
		try {
			roleService.delete(id);
			return new ResponseEntity<String>("Xóa thành công!", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Xóa thất bại!", HttpStatus.BAD_REQUEST);
		}
	}
}
