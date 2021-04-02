package com.skilldistillery.dreamtrack.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.dreamtrack.entities.Dream;
import com.skilldistillery.dreamtrack.repositories.DreamRepository;

@Service
@Transactional
public class DreamServiceImpl implements DreamService {

	@Autowired
	private DreamRepository dreamRepo;
	
	@Override
	public List<Dream> viewAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dream viewDreamById(int dreamId) {
		// TODO Auto-generated method stub
		return null;
	}

}
