package com.group1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.group1.dto.PromotionsList;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/promotions-management/view-promotions")
	public ModelAndView showAllPromotions (ModelAndView model) 
	{
		
		//Map<String, Object> map = new HashMap<String, Object>();
		PromotionsList promote = new PromotionsList();
		RestTemplate resttemp = new RestTemplate();
		String resourceUrl = "http://localhost:8080/admin/promotions-management/view-promotions";
		ResponseEntity<String> response = resttemp.getForEntity(resourceUrl, String.class);
		String responseBody = "";
		responseBody = response.getBody();
		//if(!responseBody.isBlank() || responseBody != null) System.out.println("Map object"+responseBody.toString() );
		//else System.out.println("Map object is null");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		mapper.registerModule(new JavaTimeModule());
		try {
			//map = mapper.readValue(responseBody.getBytes(), new TypeReference<Map<String, Object>>() {});
			promote = mapper.readValue(responseBody.getBytes(), PromotionsList.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//if(promotion != null) System.out.println(promotion.toString() );
		//List<Object> promoteListing = new ArrayList<Object>();
		//model.addAllObjects(map);
		model.addObject("Promotion", promote);
		//System.out.println("Model map object"+ model.getModel().toString() );
		//else System.out.println("Map object is null");
		model.setViewName("PromoteView");
		
		
		//model.setViewName("Promoteview");
		//return "Test";
		return model;
	}

	/*HttpHeaders headers = new HttpHeaders();
	headers.setContentType(new MediaType(""));
	HttpEntity<PromotionsList> entity = new HttpEntity<PromotionsList>(headers);*/
	//PromotionsList promotion = new PromotionsList();
	//if(responseBody != null || !responseBody.isBlank()) System.out.println("Promotion details:"+responseBody.toString());
	//else System.out.println("Promotion details is null");
	/*HttpStatus statusCode = response.getStatusCode();
	if(statusCode == HttpStatus.OK) 
	{
		PromotionsList promote = response.getBody();
		model.addAttribute("Promotion", promote);
		if(promote != null) System.out.println(promote.toString() );
	}*/
	//Object promotionResponse = resttemp.getForObject(resourceUrl, Object.class);
	//Map<String, Object> map = resttemp.getForObject(resourceUrl, HashMap.class) ;
}
