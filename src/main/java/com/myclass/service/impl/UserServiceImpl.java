package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.myclass.dto.UserDto;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;
import com.myclass.service.UserService;

@Service
@Transactional(rollbackOn = Exception.class)
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void add(UserDto dto) {
		User user = new User();
		user.setEmail(dto.getEmail());
		user.setFullname(dto.getFullname());	
		user.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt(12)));
	//	user.setPassword(dto.getPassword());
		user.setAvatar(dto.getAvatar());
		user.setRole_id(dto.getRole_id());
		
		userRepository.save(user);
	}

	@Override
	public List<UserDto> findAll() {
		List<UserDto> dtos = new ArrayList<UserDto>();
		
		List<User> users = userRepository.findAll();
		for (User user : users) {
			dtos.add(new UserDto(user.getId(), user.getEmail(), 
					user.getFullname(), user.getPassword(), 
					user.getAvatar(), user.getPhone(), 
					user.getAddress(), user.getRole_id()));
		}
		return dtos;
	}

	@Override
	public UserDto findById(int id) {
		User user = userRepository.findById(id).get();
		return new UserDto(user.getId(), user.getEmail(), 
				user.getFullname(), user.getPassword(), 
				user.getAvatar(), user.getPhone(), 
				user.getAddress(), user.getRole_id());
	}

	@Override
	public void update(UserDto dto) {
		User user = userRepository.findById(dto.getId()).get();
		user.setEmail(dto.getEmail());
		user.setFullname(dto.getFullname());
		user.setAvatar(dto.getAvatar());
		user.setPhone(dto.getPhone());
		user.setRole_id(dto.getRole_id());
		
		userRepository.save(user);
	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);	
	}

	@Override
	public List<UserDto> search(String keyword) {
		
		List<UserDto> dtos = new ArrayList<UserDto>();
		List<User> users = userRepository.search(keyword);
		for (User user : users) {
			dtos.add(new UserDto(user.getId(), user.getEmail(), 
				user.getFullname(), user.getPassword(), 
				user.getAvatar(), user.getPhone(), 
				user.getAddress(), user.getRole_id()));
		}
		
		return dtos;
	}

}
