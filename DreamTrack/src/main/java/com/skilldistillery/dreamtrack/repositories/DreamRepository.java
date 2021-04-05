package com.skilldistillery.dreamtrack.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dreamtrack.entities.Dream;

public interface DreamRepository extends JpaRepository<Dream, Integer> {
	
	List<Dream> findByUser_IdAndIsActive(Integer userId, Boolean isActive);
}
