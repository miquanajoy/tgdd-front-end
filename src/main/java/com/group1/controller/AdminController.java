package com.group1.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.group1.dto.CategoryList;
import com.group1.dto.ProductList;
import com.group1.dto.PromotionsList;

@Controller
@RequestMapping("/admin")
public class AdminController {

	public LocalDateTime converttoLocalDateTime(LocalDateTime toConvertTime) 
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("Date time:"+toConvertTime);
		
		String formatedDateTime = toConvertTime.format(dtf);
		System.out.println("Formatted date time:"+formatedDateTime);
		
		LocalDateTime finalFormatedTime = LocalDateTime.parse(formatedDateTime, dtf); 
		
		System.out.println("Formatted end time in object:"+finalFormatedTime);
		return finalFormatedTime;
	}
	
	@GetMapping("/promotions-management/view-promotions")
	public ModelAndView showAllPromotions (ModelAndView model) 
	{
		RestTemplate resttemp = new RestTemplate();
		String resourceUrl = "http://localhost:8080/admin/promotions-management/view-promotions";
		ResponseEntity<PromotionsList[]> response = resttemp.getForEntity(resourceUrl, PromotionsList[].class);
		model.addObject("PromoteList", response.getBody());
		model.setViewName("PromoteView");
		return model;
	}

	@GetMapping("/products-management/view-products")
	public ModelAndView showAllProducts (ModelAndView model, @RequestParam(required = false) Integer category, @RequestParam(required = false) Integer brand) 
	{
		RestTemplate resttemp = new RestTemplate();
		String resourceUrl = "http://localhost:8080/admin/products-management/view-products";
		
		if (category != null) {
			resourceUrl +="?category=" +category;
			if (brand != null) {
				resourceUrl += "&brand=" + brand;
			}
		}
		
		System.out.print(resourceUrl);
		ResponseEntity<ProductList[]> response = resttemp.getForEntity(resourceUrl, ProductList[].class);
		List<ProductList> proList = new ArrayList<ProductList>();

		for(int i=0;i< response.getBody().length; i++) 
		{
			proList.add(response.getBody()[i]);
		}
		
		
		RestTemplate restTempCat = new RestTemplate();
		String resourceUrl2 = "http://localhost:8080/admin/products-management/view-category";
		ResponseEntity<CategoryList[]> response2 = restTempCat.getForEntity(resourceUrl2, CategoryList[].class);
		List<CategoryList> CategoryList = new ArrayList<CategoryList>();
		for(int i=0;i< response2.getBody().length; i++) 
		{
			CategoryList.add(response2.getBody()[i]);
		}
//		
//		if (category != null) {
//			RestTempplate..category.byteValue()
//			model.addObject("brandList", brand);
//		}
		
		model.addObject("ProductList", proList);
		model.addObject("cats", CategoryList);
		model.setViewName("ProductView");
		return model;
	}
	
	
	
	@GetMapping("/promotions-management/create-promotion")
	public ModelAndView newPromotionInput (ModelAndView model) 
	{
		RestTemplate resttemp = new RestTemplate();
		String resourceUrl = "http://localhost:8080/admin/promotions-management/create-promotion";
		ResponseEntity<PromotionsList> response = resttemp.getForEntity(resourceUrl, PromotionsList.class);
		PromotionsList promotionCreateForm = response.getBody();
		String enableButton = "";
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime limit = now.plusMonths(2);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");		
		
		String formatedNowTime = now.format(dtf);
		String formatedLimitTime = limit.format(dtf);
		
		model.addObject("MinDateTime", formatedNowTime);
		model.addObject("MaxDateTime", formatedLimitTime);
		model.addObject("PromoteCreateForm", promotionCreateForm);
		model.addObject("EnableCheck", enableButton);
		model.setViewName("PromoteAdd");
		return model;
	}
	
	@PostMapping("/promotions-management/create-promotion")
	public ModelAndView CreateANewPromotion (@ModelAttribute("PromoteCreateForm") PromotionsList promoteInputForm
	, @ModelAttribute("EnableCheck") String checkEnable, ModelAndView model) 
	{
		RestTemplate resttemp = new RestTemplate();
		String checkPromoteExistUrl = "http://localhost:8080/admin/promotions-management/get-promotion/" 
		+promoteInputForm.getPromoteCodeName();
		String savePromotionUrl = "http://localhost:8080/admin/promotions-management/create-promotion";
		
		if(checkEnable.equals("Enable")) promoteInputForm.setEnabled(true);
		if(checkEnable.equals("Disable")) promoteInputForm.setEnabled(false);
		
		int errorCount = 0;
		
		ResponseEntity<PromotionsList> response1 = resttemp.getForEntity(checkPromoteExistUrl, PromotionsList.class);
		
		PromotionsList checkPromote = response1.getBody();
		if(checkPromote != null) 
		{
			System.out.println("Promotion name already existed");
			errorCount +=1;
			String promoteNameDupWarning = "Promotion name already existed";
			model.addObject("PromoteNameDup", promoteNameDupWarning);
		}
		
		if(promoteInputForm.getStartDateInput().isEqual(promoteInputForm.getEndDateInput())) 
		{
			System.out.println("Promotion start date and end date cannot be the same");
			errorCount +=1;
			String startSameAsEnd = "Promotion start date and end date cannot be the same";
			model.addObject("StartSameAsEnd", startSameAsEnd);
		}
		else if(promoteInputForm.getStartDateInput().isAfter(promoteInputForm.getEndDateInput())) 
		{
			System.out.println("Promotion start date cannot be after end date");
			errorCount +=1;
			String starIsAfterEnd = "Promotion start date can't be after end date";
			model.addObject("StartIsAfterEnd", starIsAfterEnd);
		}
		
		if(errorCount >0) 
		{
			LocalDateTime now = LocalDateTime.now();
			LocalDateTime limit = now.plusMonths(2);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");		
			
			String formatedNowTime = now.format(dtf);
			String formatedLimitTime = limit.format(dtf);
			model.addObject("MinDateTime", formatedNowTime);
			model.addObject("MaxDateTime", formatedLimitTime);
			model.addObject("PromoteForm", promoteInputForm);
			//model.addObject("EnableCheck", enableButton);
			model.setViewName("PromoteAdd");
		}
		else {
			LocalDateTime convertStartTime = converttoLocalDateTime(promoteInputForm.getStartDateInput());
			
			LocalDateTime convertEndTime = converttoLocalDateTime(promoteInputForm.getEndDateInput());
			
			promoteInputForm.setStartDate(convertStartTime);
			promoteInputForm.setEndDate(convertEndTime);
			
			ResponseEntity<PromotionsList> response = 
			resttemp.postForEntity(savePromotionUrl, promoteInputForm, PromotionsList.class);
		
			HttpStatus statusCode = response.getStatusCode();
			if(statusCode == HttpStatus.OK) 
			{
				System.out.println("Promotion has successfully been added");
				System.out.println("Promotion details:" +promoteInputForm.toString());
			}
			//if(statusCode == HttpStatus.) 
			model.addObject("PromoteNameDup", null);
			model.addObject("StartSameAsEnd", null);
			model.addObject("StartIsAfterEnd", null);
			model.setViewName("redirect:/admin/promotions-management/view-promotions");
		}
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
