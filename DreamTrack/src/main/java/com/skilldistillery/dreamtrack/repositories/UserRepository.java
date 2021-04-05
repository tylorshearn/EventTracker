package com.skilldistillery.dreamtrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dreamtrack.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
