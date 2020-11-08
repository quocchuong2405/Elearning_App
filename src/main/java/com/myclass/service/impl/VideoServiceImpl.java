package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.VideoDto;
import com.myclass.entity.Video;
import com.myclass.repository.VideoRepository;
import com.myclass.service.VideoService;

@Service
@Transactional(rollbackOn = Exception.class)
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoRepository videoRepository;

	@Override
	public List<VideoDto> findAll() {
		List<VideoDto> dtos = new ArrayList<VideoDto>();

		List<Video> videos = videoRepository.findAll();

		for (Video video : videos) {
			dtos.add(new VideoDto(video.getId(), video.getTitle(), video.getTime_count(),
					video.getUrl(), video.getCourse_id()));
		}
		return dtos;
	}

	@Override
	public VideoDto findById(int id) {
		Video video = videoRepository.findById(id).get();
		return new VideoDto(video.getId(), video.getTitle(), video.getTime_count(),
				video.getUrl(), video.getCourse_id());
	}

	@Override
	public void add(VideoDto dto) {
		Video video = new Video();
		video.setTitle(dto.getTitle());
		video.setUrl(dto.getUrl());
		video.setCourse_id(dto.getCourse_id());
		video.setTime_count(dto.getTime_count());
		
		videoRepository.save(video);

	}

	@Override
	public void update(VideoDto dto) {
		Video video = videoRepository.findById(dto.getId()).get();
		video.setTitle(dto.getTitle());
		video.setUrl(dto.getUrl());
		video.setTime_count(dto.getTime_count());
		video.setCourse_id(dto.getCourse_id());
		
		videoRepository.save(video);
	}

	@Override
	public void delete(int id) {
		videoRepository.deleteById(id);
	}

	@Override
	public List<VideoDto> search(String keyword) {
		List<VideoDto> dtos = new ArrayList<VideoDto>();
		List<Video> videos = videoRepository.search(keyword);
		for (Video video : videos) {
			dtos.add(new VideoDto(video.getId(), video.getTitle(), video.getTime_count(),
				video.getUrl(), video.getCourse_id()));
		}
		return dtos;
	}

}
