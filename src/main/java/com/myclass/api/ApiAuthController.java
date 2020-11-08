package com.myclass.api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.LoginDto;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("api")
public class ApiAuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("login")
	public ResponseEntity<String> login(@RequestBody LoginDto loginDto) { 
		Authentication authentication = null;
		
		try {
			// GỌI PHƯƠNG THỨC ĐĂNG NHẬP CỦA SPRING SECURITY
			authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			// gọi phương thức tạo chuỗi token
			return new ResponseEntity<String>(generateToken(authentication), HttpStatus.OK); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Sai tên đăng nhập hoặc mật khẩu", HttpStatus.BAD_REQUEST);
	}
	
	private String generateToken (Authentication authentication) {
		// private JWT_SECRET, just server knows this private text
		final String JWT_SECRET = "chuongdeptrai";
		
		// The validity period is 10 days
		final long JWT_EXPIRATION = 86000000L;
		
		Date now = new Date();
		Date expiDate = new Date(now.getTime() + JWT_EXPIRATION);
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		// Create json web token string from id of user
		String token = Jwts.builder()
				.setSubject(userDetails.getUsername())
				.setIssuedAt(now)
				.setExpiration(expiDate)
				.signWith(SignatureAlgorithm.HS512, JWT_SECRET)
				.compact();
		return token;
	}
	
}
