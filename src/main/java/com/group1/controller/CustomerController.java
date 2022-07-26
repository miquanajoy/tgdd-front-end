package com.group1.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.group1.dto.ColorVariantUpdateDTO;
import com.group1.dto.CustomerViewProductDetails.ColorVariantDetails;
import com.group1.dto.CustomerViewProductDetails.GeneralProductDetails;
import com.group1.dto.CustomerViewProductDetails.ProductVariantDetails;
import com.group1.entities.product.ProductColorVariant;

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
}
