package com.skilldistillery.dreamtrack.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.dreamtrack.entities.Dream;
import com.skilldistillery.dreamtrack.entities.User;
import com.skilldistillery.dreamtrack.repositories.DreamRepository;
import com.skilldistillery.dreamtrack.repositories.UserRepository;

@Service
@Transactional
public class DreamServiceImpl implements DreamService {

	@Autowired
	private DreamRepository dreamRepo;
	@Autowired 
	private UserRepository userRepo;
	
	@Override
	public List<Dream> viewAllDreams() {
		return dreamRepo.findAll();
	}

	@Override
	public Dream viewDreamById(int dreamId) {
		dreamRepo.findById(dreamId);
		return null;
	}

	@Override
	public List<Dream> findDreamByUserIdAndIsActive(Integer userId, Boolean isActive) {
		if (! dreamRepo.existsById(userId)) {
			return null;
		}
		return dreamRepo.findByUser_IdAndIsActive(userId, isActive);
	}

//	@Override
//	public Dream createDream(Dream dream) {
//		return dreamRepo.saveAndFlush(dream);
//	}

	public Dream createDream(Integer userId, Dream dream) {
		Optional<User> optionalUser = userRepo.findById(userId);
		if (optionalUser.isPresent()) {
			dream.setUser(optionalUser.get());
			dream.setDreamtOn(LocalDateTime.now());
			return dreamRepo.saveAndFlush(dream);
		}
		return null;
	}

	@Override
	public Dream updateDream(Integer userId, Integer dreamId, Dream dream) {
		Optional<User> optionalUser = userRepo.findById(userId);
		if (optionalUser.isPresent()) {
			dream.setUser(optionalUser.get());
			return dreamRepo.saveAndFlush(dream);
		}
		return null;
	}

}
