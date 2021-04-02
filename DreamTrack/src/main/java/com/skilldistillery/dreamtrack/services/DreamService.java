package com.skilldistillery.dreamtrack.services;

import java.util.List;

import com.skilldistillery.dreamtrack.entities.Dream;

public interface DreamService {
	
	List<Dream> viewAllDreams();
	Dream viewDreamById(int dreamId);
}
