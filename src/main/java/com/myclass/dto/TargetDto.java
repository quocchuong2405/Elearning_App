package com.myclass.dto;

public class TargetDto {
	private int id;
	private String title;
	private int course_id;
	
	public TargetDto() {}
	
	public TargetDto(int id, String title, int course_id) {
		super();
		this.id = id;
		this.title = title;
		this.course_id = course_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
}
