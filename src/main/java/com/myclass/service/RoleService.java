package com.myclass.service;

import java.util.List;

import com.myclass.dto.RoleDto;


public interface RoleService {
	List<RoleDto> findAll();
	RoleDto findById(int id);
	void add(RoleDto dto);
	void update(RoleDto dto);
	void delete(int id);
	public List<RoleDto> search(String keyword);
}
