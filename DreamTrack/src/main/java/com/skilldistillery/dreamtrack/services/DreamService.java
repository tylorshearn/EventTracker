package com.skilldistillery.dreamtrack.services;

import java.util.List;

import com.skilldistillery.dreamtrack.entities.Dream;

public interface DreamService {
	
	List<Dream> viewAllDreams();
	
	Dream viewDreamById(int dreamId);
	
	List<Dream> findDreamByUserIdAndIsActive(Integer userId, Boolean isActive);
	
	Dream createDream(Integer userId, Dream dream);

	Dream updateDream(Integer userId, Integer dreamId, Dream dream);
	
//	Dream createDream(Dream dream);
}
