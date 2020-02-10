package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.entities.Language;
import com.skilldistillery.eventtracker.services.LanguageService;

@RestController
@RequestMapping("api")
public class LanguageController {
	@Autowired
	private LanguageService srv;
	
	@GetMapping("ping")
	public String ping(HttpServletResponse response) {
		response.setStatus(200);
		return "pong";
	}
	@GetMapping("languages/{id}")
	public Language getLanguage(@PathVariable("id")Integer id,HttpServletResponse response) {
		Language language = srv.getLanguage(id);
		if(language == null) {
			response.setStatus(404);
		}else {
			response.setStatus(200);
		}
		return language;
	}
	@GetMapping("languages")
	public List<Language> getLanguages(HttpServletResponse response) {
		response.setStatus(200);
		return srv.getLanguages();
	}
	@PostMapping("languages")
	public Language postLanguage( @RequestBody Language language, HttpServletResponse response) {
		try {
		language = srv.createLanguage(language);
		if(language == null) {
			response.setStatus(400);
			return null;
		}else {
			response.setStatus(201);
			return language;
		}
		}catch(Exception e) {
			response.setStatus(400);
			return null;
		}
	}
	@PutMapping("languages/{id}")
	public Language putLanguage(@PathVariable("id")Integer id, @RequestBody Language language, HttpServletResponse response) {
		if(language.getId() != null && !language.getId().equals(id)) {
			response.setStatus(400);
			return null;
		}
		language.setId(id);
		try {
		language = srv.updateLanguage(language);
		if(language == null) {
			response.setStatus(404);
			return null;
		}else {
			response.setStatus(200);
			return language;
		}
		}catch(Exception e) {
			response.setStatus(400);
			return null;
		}
	}
	@DeleteMapping("languages/{id}")
	public void deleteLanguage(@PathVariable("id")Integer id, HttpServletResponse response) {
		Boolean worked = srv.deleteLanguage(id);
		if(worked == null) {
			response.setStatus(400);
			return; 
		}
		if(!worked) {
			response.setStatus(404);
			return; 
		}
		if(worked) {
			response.setStatus(200);
			return; 
		}
	}
}
