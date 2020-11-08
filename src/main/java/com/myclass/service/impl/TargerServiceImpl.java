package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.TargetDto;
import com.myclass.entity.Target;
import com.myclass.repository.TargetRepository;
import com.myclass.service.TargetService;

@Service
@Transactional(rollbackOn = Exception.class)
public class TargerServiceImpl implements TargetService {
	@Autowired
	private TargetRepository targetRepository;

	@Override
	public List<TargetDto> findAll() {
		List<TargetDto> dtos = new ArrayList<TargetDto>();
		
		List<Target> targets = targetRepository.findAll();
		for (Target target : targets) {
			dtos.add(new TargetDto(target.getId(), target.getTitle(), target.getCourse_id()));
		}
		return dtos;
	}

	@Override
	public TargetDto findById(int id) {
		Target target = targetRepository.findById(id).get();
		return new TargetDto(target.getId(), target.getTitle(), target.getCourse_id());
	}

	@Override
	public void add(TargetDto dto) {
		Target target = new Target();
		target.setTitle(dto.getTitle()); 
		target.setCourse_id(dto.getCourse_id());
		
		targetRepository.save(target);
	}

	@Override
	public void update(TargetDto dto) {
		Target target = targetRepository.findById(dto.getId()).get();
		target.setTitle(dto.getTitle()); 
		target.setCourse_id(dto.getCourse_id());
		
		targetRepository.save(target);
	}

	@Override
	public void delelte(int id) {
		targetRepository.deleteById(id);
	}
	
	
}
