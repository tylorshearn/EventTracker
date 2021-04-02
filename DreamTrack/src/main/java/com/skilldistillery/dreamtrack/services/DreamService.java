package com.skilldistillery.dreamtrack.services;

import java.util.List;

import com.skilldistillery.dreamtrack.entities.Dream;

public interface DreamService {
	
	List<Dream> viewAll();
	Dream viewDreamById(int dreamId);
}
