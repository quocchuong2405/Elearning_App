package com.myclass.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.myclass.security.JWTAuthorizationFilter;

@Configuration
@EnableWebSecurity
@ComponentScan("com.myclass")
public class ApiSercurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	// KHỞI TẠO ĐỐI TƯỢNG AUTHENTICATIONMANAGER SỬ DỤNG ĐỂ GỌI PHƯƠNG THỨC KIỂM TRA ĐĂNG NHẬP
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	// Khai báo service lấy thông tin user từ db và khai báo phương thức mã hóa password
	@Override
	protected void configure(AuthenticationManagerBuilder auth) 
			throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.cors();
		 
		http.csrf().disable()
		.antMatcher("/api/**") //chỉ phân quyền áp dụng cho url bắt đầu /api
		.authorizeRequests()
		.antMatchers("/api/login", "/api/category**")
		.permitAll()
		.antMatchers("/api/user/**")
		.hasAnyRole("ADMIN")
		.antMatchers("/api/user/**")
		.hasAnyRole("ADMIN", "TEACHER")
		.anyRequest()
		.authenticated();
		
		// Sử dụng JWTAuthorization để check token => lấy thông tin người dùng
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), userDetailsService));
		
		// Cấu hình không sử hình Session lưu thông tin từ client
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
