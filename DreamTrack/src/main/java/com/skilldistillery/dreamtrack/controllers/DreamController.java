package com.skilldistillery.dreamtrack.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.dreamtrack.entities.Dream;
import com.skilldistillery.dreamtrack.services.DreamService;

@RequestMapping("api")
@RestController
public class DreamController {
	
	@Autowired
	private DreamService dreamService;
	
	@GetMapping("dreams")
	public List<Dream> viewAllDreams() {
		return dreamService.viewAllDreams();
	}
	
	@GetMapping(path="user/{userId}/{isActive}/dreams")
	public List<Dream> findDreamByUserIdAndIsActive(@PathVariable Integer userId,@PathVariable Boolean isActive, HttpServletResponse resp) {
		List<Dream> dreams = dreamService.findDreamByUserIdAndIsActive(userId, isActive);
		if (dreams == null) {
			resp.setStatus(404);
		}
		return dreams;
	}
	
	@PostMapping("user/{userId}/dreams")
	public Dream createDream(@PathVariable Integer userId,@RequestBody Dream dream, HttpServletRequest req, HttpServletResponse resp) {
		dream = dreamService.createDream(userId, dream);
		if (dream != null) {
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(dream.getId());
			resp.setHeader("Location", url.toString());
		}
		else {
			resp.setStatus(404);
			dream = null;
		}
		return dream;
	}
	
	@PutMapping(path="user/{userId}/{dreamId}/dreams") 
	public Dream updateDream(@PathVariable Integer userId, @PathVariable Integer dreamId, @RequestBody Dream dream, HttpServletResponse resp) {
		try {
			dream = dreamService.updateDream(userId, dreamId, dream);
			if (dream == null) {
				resp.setStatus(404);
			}
		} catch (Exception e) {
			System.err.println(e);
			resp.setStatus(400);
			dream = null;
			//e.printStackTrace();
		}
		return dream;
	}
	
//	@PostMapping("dreams")
//	public Dream createDream(@RequestBody Dream dream, HttpServletRequest req, HttpServletResponse resp) {
//		dream = dreamService.createDream(dream);
//		if (dream != null) {
//			resp.setStatus(201);
//			StringBuffer url = req.getRequestURL();
//			url.append("/").append(dream.getId());
//			resp.setHeader("Location", url.toString());
//		}
//		else {
//			resp.setStatus(404);
//			dream = null;
//		}
//		return dream;
//	}
}
