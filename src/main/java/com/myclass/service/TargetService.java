package com.myclass.service;

import java.util.List;

import com.myclass.dto.TargetDto;

public interface TargetService {
	List<TargetDto> findAll();
	TargetDto findById(int id);
	void add(TargetDto dto);
	void update(TargetDto dto);
	void delelte(int id);
}
