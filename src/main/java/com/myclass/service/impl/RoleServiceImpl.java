package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.RoleDto;
import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;
import com.myclass.service.RoleService;

@Service
@Transactional(rollbackOn = Exception.class)
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public List<RoleDto> findAll() {
		List<RoleDto> dtos = new ArrayList<RoleDto>();

		List<Role> roles = roleRepository.findAll();
		for (Role role : roles) {
			dtos.add(new RoleDto(role.getId(), role.getName(), role.getDescription()));
		}
		return dtos;
	}

	public RoleDto findById(int id) {
		Role role = roleRepository.findById(id).get();
		return new RoleDto(role.getId(), role.getName(), role.getDescription());
	}

	public void add(RoleDto dto) {
		Role role = new Role(dto.getId(), dto.getName(), dto.getDescription());
		roleRepository.save(role);
	}

	public void update(RoleDto dto) {
		Role role = roleRepository.findById(dto.getId()).get();
		role.setName(dto.getName());
		role.setDescription(dto.getDescription());
		roleRepository.save(role);
	}

	public void delete(int id) {
		roleRepository.deleteById(id);
	}

	public List<RoleDto> search(String keyword) {
		
		List<RoleDto> dtos = new ArrayList<RoleDto>();

		List<Role> roles = roleRepository.search(keyword);
		for (Role role : roles) {
			dtos.add(new RoleDto(role.getId(), role.getName(), role.getDescription()));
		}
		
		return dtos;
	}

}
