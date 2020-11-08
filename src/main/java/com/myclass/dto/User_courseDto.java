package com.myclass.dto;

public class User_courseDto {
	private int user_id;
	private int course_id;
	private int role_id;
	
	public User_courseDto() {}
	
	public User_courseDto(int user_id, int course_id, int role_id) {
		super();
		this.user_id = user_id;
		this.course_id = course_id;
		this.role_id = role_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
}
