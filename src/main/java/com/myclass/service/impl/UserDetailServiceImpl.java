package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myclass.dto.UserDetailsDto;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) 
			throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(email);
		if(user == null) throw new UsernameNotFoundException("Sai email!");
		
		// Lấy quyền của người dùng
		String roleName = user.getRoles().getName();
		
		// Tạo danh sách chứa quyền người dùng
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(roleName));
		
		UserDetailsDto dto = new UserDetailsDto(user.getEmail(), user.getPassword(), authorities);
		
		return dto;
	}

}
