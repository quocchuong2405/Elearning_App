package com.myclass.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Khai báo cho Hibernate biết lớp này sẽ ánh xạ đến 1 bảng trong DB
@Entity
@Table(name = "roles") // ÁNh xạ lớp Role với bảng roles trong db
public class Role {

	@Id // Khai báo đây khóa chính
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Khai báo khóa chính tăng tự động
	private int id;
	
	@Column(name = "name") // Ánh xạ thuộc tính name đến cột name trong table
	private String name;
	
	private String description;
	
	@OneToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private List<User> users; // done
	
	@OneToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private List<User_course> user_courses;
	
	public Role() {}

	public Role(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
