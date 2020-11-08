package com.myclass.dto;

public class VideoDto {
	private int id;
	private String title;
	private int time_count;
	private String url;
	private int course_id;
	
	public VideoDto() {}
	
	public VideoDto(int id, String title, int time_count, String url, int course_id) {
		super();
		this.id = id;
		this.title = title;
		this.time_count = time_count;
		this.url = url;
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
	public int getTime_count() {
		return time_count;
	}
	public void setTime_count(int time_count) {
		this.time_count = time_count;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	
}
