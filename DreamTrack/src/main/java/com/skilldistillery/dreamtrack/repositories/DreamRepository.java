package com.skilldistillery.dreamtrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dreamtrack.entities.Dream;

public interface DreamRepository extends JpaRepository<Dream, Integer> {

}
