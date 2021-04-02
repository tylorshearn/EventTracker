package com.skilldistillery.dreamtrack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.dreamtrack.entities.Dream;
import com.skilldistillery.dreamtrack.services.DreamService;

@RequestMapping("api")
@RestController
public class DreamController {
	
	@Autowired
	private DreamService dreamService;
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
	}
	
	@GetMapping("dreams")
	public List<Dream> viewAllDreams() {
		return dreamService.viewAllDreams();
	}
}
