package com.myclass.dto;

import java.util.Date;

public class CourseDto {
	private int id;
	private String title; 
	private String image;
	private int lectures_count;
	private int hour_count;
	private Date last_update;
	private int view_count;
	private float price;
	private int discount;
	private int promotion_price;
	private String description;
	private int category_id;
	
	public CourseDto() {}

	public CourseDto(int id, String title, String image, int lectures_count, int hour_count, Date last_update,
			int view_count, float price, int discount, int promotion_price, String description, int category_id) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.lectures_count = lectures_count;
		this.hour_count = hour_count;
		this.last_update = last_update;
		this.view_count = view_count;
		this.price = price;
		this.discount = discount;
		this.promotion_price = promotion_price;
		this.description = description;
		this.category_id = category_id;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLectures_count() {
		return lectures_count;
	}

	public void setLectures_count(int lectures_count) {
		this.lectures_count = lectures_count;
	}

	public int getHour_count() {
		return hour_count;
	}

	public void setHour_count(int hour_count) {
		this.hour_count = hour_count;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	public int getView_count() {
		return view_count;
	}

	public void setView_count(int view_count) {
		this.view_count = view_count;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getPromotion_price() {
		return promotion_price;
	}

	public void setPromotion_price(int promotion_price) {
		this.promotion_price = promotion_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	
}
