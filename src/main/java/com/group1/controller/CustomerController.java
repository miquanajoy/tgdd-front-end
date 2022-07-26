package com.group1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.group1.dto.CategoryList;
import com.group1.dto.ManufacturerList;
import com.group1.dto.ProductList;

@Controller
public class CustomerController {
	
	@GetMapping("/")
	public String  redirect() {
		return "redirect:/view-products";
	}
	
	@GetMapping("/view-products")
	public ModelAndView showAllProducts (ModelAndView model, 
			@RequestParam(required = false) Integer category, 
			@RequestParam(required = false) Integer manufacturer,
			@RequestParam(required = false) String name) 
	{
		RestTemplate resttemp = new RestTemplate();
		UriComponentsBuilder uriBuilder = UriComponentsBuilder
				.fromHttpUrl("http://localhost:8080")
				.path("/view-products");
		System.out.print("abe");
		
		
		if (category != null) {
			uriBuilder = uriBuilder.query("category=" + category);
			
			RestTemplate restTempManu = new RestTemplate();
			String resourceUrl3 = "http://localhost:8080/view-manufacturer?categoryId=" +category;
			ResponseEntity<ManufacturerList[]> response3 = restTempManu.getForEntity(resourceUrl3, ManufacturerList[].class);
			List<ManufacturerList> manufacturerList = new ArrayList<ManufacturerList>();
			
			for(int i=0;i< response3.getBody().length; i++) 
			{
				manufacturerList.add(response3.getBody()[i]);
			}
			
			model.addObject("manu", manufacturerList);
			
			if (manufacturer != null) {
				uriBuilder = uriBuilder.query("manufacturer=" + manufacturer);
			}
		}
		
		if (name != null) {
			uriBuilder = uriBuilder.query("name=" + name);
		}
			
		System.out.println(uriBuilder.build(""));
		ResponseEntity<ProductList[]> response = resttemp.getForEntity(uriBuilder.build(""), ProductList[].class);
		List<ProductList> proList = new ArrayList<ProductList>();

		for(int i=0;i< response.getBody().length; i++) 
		{
			proList.add(response.getBody()[i]);
		}
		
		
		RestTemplate restTempCat = new RestTemplate();
		String resourceUrl2 = "http://localhost:8080/view-category";
		ResponseEntity<CategoryList[]> response2 = restTempCat.getForEntity(resourceUrl2, CategoryList[].class);
		List<CategoryList> categoryList = new ArrayList<CategoryList>();
		
		
		for(int i=0;i< response2.getBody().length; i++) 
		{
			categoryList.add(response2.getBody()[i]);
		}

		
		model.addObject("ProductList", proList);
		model.addObject("cats", categoryList);
		
		model.setViewName("index");
		return model;
	}

}
