package com.group1.controller;

import java.util.ArrayList;

import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.group1.dto.ColorVariantUpdateDTO;
import com.group1.dto.CustomerViewProductDetails.ColorVariantDetails;
import com.group1.dto.CustomerViewProductDetails.GeneralProductDetails;
import com.group1.dto.CustomerViewProductDetails.ProductVariantDetails;
import com.group1.entities.product.ProductColorVariant;

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
	
	@GetMapping("/view-product-details/{prodID}")
	public ModelAndView getAProductDetails(@PathVariable("prodID") String pID, ModelAndView model) 
	{
		RestTemplate resttemp = new RestTemplate();
		String viewProductDetailUrl = "http://localhost:8080/view-details-product/"+pID;
		
		ResponseEntity<GeneralProductDetails> productDetailsResponse =
		resttemp.getForEntity(viewProductDetailUrl, GeneralProductDetails.class);
		
		GeneralProductDetails finalProduct = productDetailsResponse.getBody();
		
		if(finalProduct.getColorVariant().size() >0) {
		List<ColorVariantUpdateDTO> colorVarUpdateList = new ArrayList<ColorVariantUpdateDTO>();
		
		for(ColorVariantDetails el: finalProduct.getColorVariant()) 
		{ 	
			if(colorVarUpdateList.size() == 0) {
				ColorVariantUpdateDTO colUpdateForm = new ColorVariantUpdateDTO();
				colUpdateForm.setForColorID(el.getColorID());
				colUpdateForm.setForColorName(el.getColorName());
				colorVarUpdateList.add(colUpdateForm);
				continue;
			}
			
			int countOccur = 0;
			if(colorVarUpdateList.size() > 0) {
				for(ColorVariantUpdateDTO obj: colorVarUpdateList) {
					if(obj.getForColorID() != el.getColorID()) {
						countOccur +=1;
					}
				}
				if(countOccur == colorVarUpdateList.size()) {
					ColorVariantUpdateDTO colUpdateForm = new ColorVariantUpdateDTO();
					colUpdateForm.setForColorID(el.getColorID());
					colUpdateForm.setForColorName(el.getColorName());
					colorVarUpdateList.add(colUpdateForm);
				}
			}
		}
		model.addObject("ProductColorList", colorVarUpdateList);
		}
		
		if(finalProduct.getOriginal() != null) 
		{
			for(ProductVariantDetails it: finalProduct.getOriginal()) {
				
				if(!finalProduct.getProductID().equals(it.getProductOriginalIdentifier()) )
				{
					String originID = it.getProductOriginalIdentifier();
					model.addObject("OriginalIdentifier", originID);
					break;
				}
			}
		}
		if(finalProduct.getUnboxing() != null)
		model.addObject("UnboxingName", "Hình mở hộp:");
		if(finalProduct.getCameraShots()!= null)
		model.addObject("CameraName", "Chụp từ Camera:");
		model.setViewName("viewProductDetails");
		model.addObject("ProductDetails", finalProduct);
		return model;
	}

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
