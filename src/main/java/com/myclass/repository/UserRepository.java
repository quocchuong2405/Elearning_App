package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myclass.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//	@Query("SELECT * from users")
//	public List<User> findAll();
	
	public User findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.email = :keyword OR u.fullname = :keyword")
	public List<User> search(@Param("keyword") String keyword);
}
