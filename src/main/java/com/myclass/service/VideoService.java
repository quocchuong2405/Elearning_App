package com.myclass.service;

import java.util.List;

import com.myclass.dto.VideoDto;

public interface VideoService {
	List<VideoDto> findAll();
	VideoDto findById(int id);
	void add(VideoDto dto);
	void update(VideoDto dto);
	void delete(int id);
	public List<VideoDto> search(String keyword);
}
