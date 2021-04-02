package com.skilldistillery.dreamtrack.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api")
@RestController
public class DreamController {
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
	}
}
