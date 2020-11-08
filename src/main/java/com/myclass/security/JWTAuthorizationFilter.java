package com.myclass.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	private UserDetailsService _userDetailsService;

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
		super(authenticationManager);
		_userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		final String JWT_SECRET = "chuongdeptrai";
		// Lấy chuỗi token từ header của request
		String tokenBearer = request.getHeader("Authorization");
		
		//Kiểm tra token được đính kèm vào request chưa
		// và có đúng định dạng ko ( token bắt đầu bằng Bearer)
		if (tokenBearer != null && tokenBearer.startsWith("Bearer ")) {
			// thay thế "Bearer " bằng "" để lấy chuỗi token chính xác
			String token = tokenBearer.replace("Bearer ", "");
			
			// giải mã token lấy email
			String email = Jwts.parser()
					.setSigningKey(JWT_SECRET)
					.parseClaimsJws(token)
					.getBody()
					.getSubject();
			
			// Lấy thông tin user từ db
			UserDetails userDetails = _userDetailsService.loadUserByUsername(email);
			
			//Nếu người dùng hợp lệ, set thông tin cho Security Context
			UsernamePasswordAuthenticationToken authenticationToken =
					new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		chain.doFilter(request, response);
	}
}
