package com.group1.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping("/home")
	public String home(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8080/admin/home";
		ResponseEntity<String> responseEntity
				= restTemplate.getForEntity(fooResourceUrl, String.class);
		model.addAttribute("text", responseEntity.getBody());
		return "index";
		
	}
	
}
