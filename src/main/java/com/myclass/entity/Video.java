package com.myclass.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "videos")
public class Video {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private int time_count;
	private String url;
	private int course_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "courses_id", insertable = false, updatable = false)
	private Course courses; // done
	
	public Video() {}
	
	public Video(int id, String title, int time_count, String url, int course_id) {
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
