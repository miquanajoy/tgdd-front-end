package com.group1.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.catalina.connector.Response;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group1.dto.Attributes;
import com.group1.dto.ColorVariantUpdateDTO;
import com.group1.dto.MultiFieldsFilePathDTO;
import com.group1.dto.SpecSection;
import com.group1.entities.product.Category;
import com.group1.entities.product.Color;
import com.group1.entities.product.Manufacturer;
import com.group1.entities.product.Product;
import com.group1.entities.product.ProductArticle;
import com.group1.entities.product.ProductCameraShot;
import com.group1.entities.product.ProductColorVariant;
import com.group1.entities.product.ProductDiscount;
import com.group1.entities.product.ProductFeature;
import com.group1.entities.product.ProductSpecification;
import com.group1.entities.product.ProductTechSpecs;
import com.group1.entities.product.ProductUnboxingReview;
import com.group1.entities.product.ProductVariant;
import com.group1.entities.shopping.PromoteCode;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/products-management/view-products")
	public ModelAndView showAllProducts (ModelAndView model) 
	{
		RestTemplate resttemp = new RestTemplate();
		String resourceUrl = "http://localhost:8080/admin/products-management/view-products";

		ResponseEntity<Product[]> response = resttemp.getForEntity(resourceUrl, Product[].class);
		List<Product> proList = new ArrayList<Product>();
		
		model.addObject("ProductList", proList);

		
		model.setViewName("ProductView");
		return model;
	}
	
	@GetMapping("/products-management/create-product/choose-category")
	public ModelAndView chooseProductCategory(ModelAndView model) 
	{
		RestTemplate resttemp = new RestTemplate();
		String takeCategoriesUrl = "http://localhost:8080/admin/get-categories";
		ResponseEntity<Category[]> response = resttemp.getForEntity(takeCategoriesUrl, Category[].class);
		
		List<Category> categoryList = Arrays.asList(response.getBody());
		model.setViewName("ProductCreate");
		model.addObject("CategoryList", categoryList);
		return model;
	}
	
	@GetMapping("/products-management/create-product/step-1")
	public ModelAndView AddProductStep1(ModelAndView model, @ModelAttribute("Categorychosen") int catechosen
			, @ModelAttribute("ColorVariantNumber") int colorVarNum) 
	{
		//int catechose = catechosen;
		
		Product productInputForm = new Product();
		System.out.println("Cate chosen Name:"+catechosen);
		RestTemplate resttemp = new RestTemplate();

		String findSpecificCateUrl = "http://localhost:8080/admin/get-specific-category";
		String getAllColorUrl = "http://localhost:8080/admin/get-colors";
		String getCateBasedBrandUrl = "http://localhost:8080/admin/get-category-brands";
		String getCateBasedSpecsUrl = "http://localhost:8080/admin/get-category-specs";
		String convertSpecsToFormUrl = "http://localhost:8080/admin/convert-specs-to-form";
		
		String cateName = "";
		
		ResponseEntity<Category> findCateResponse = 
		resttemp.postForEntity(findSpecificCateUrl, catechosen , Category.class);
		Category matchCate = findCateResponse.getBody();
		cateName = matchCate.getCategoryName();
		
		ResponseEntity<Color[]> getColorsResponse = resttemp.getForEntity(getAllColorUrl, Color[].class);
		List<Color> colorList = Arrays.asList(getColorsResponse.getBody());
		
		ResponseEntity<Manufacturer[]> getCateBrandsResponse = 
		resttemp.postForEntity(getCateBasedBrandUrl, matchCate.getCategoryID() , Manufacturer[].class);
		List<Manufacturer> manuList = Arrays.asList(getCateBrandsResponse.getBody());
		
		ResponseEntity<ProductTechSpecs[]> getCateSpecsResponse = 
		resttemp.postForEntity(getCateBasedSpecsUrl, matchCate.getCategoryID() , ProductTechSpecs[].class);
		List<ProductTechSpecs> specList = Arrays.asList(getCateSpecsResponse.getBody());
		
		MultiFieldsFilePathDTO multi = new MultiFieldsFilePathDTO();
		List<ProductColorVariant> colorInputFormList = new ArrayList<ProductColorVariant>();
		
		productInputForm.setCategoryID(matchCate.getCategoryID());

		ResponseEntity<SpecSection[]> SpecFormResponse = 
		resttemp.postForEntity(convertSpecsToFormUrl, specList , SpecSection[].class);
		List<SpecSection> newSpecList = Arrays.asList(SpecFormResponse.getBody());

		productInputForm.setSpecList(newSpecList);
		ProductArticle article = new ProductArticle();
		productInputForm.setArticle(article);
		
		if(colorVarNum >0) {
		productInputForm.setColorVariantInputList(colorInputFormList);
		
			for(int i = 0; i < colorVarNum;i++) {
				ProductColorVariant colorvar = new ProductColorVariant();
				productInputForm.getColorVariantInputList().add(colorvar);
			}
		
		}

		LocalDateTime now = LocalDateTime.now();
		LocalDateTime limit = now.plusMonths(2);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");		
		
		String formatedNowTime = now.format(dtf);
		String formatedLimitTime = limit.format(dtf);
		
		ProductVariant variant = new ProductVariant();
		productInputForm.setVariant(variant);
		
		model.addObject("ProductInputForm", productInputForm);
		model.setViewName("ProductCreate");
		model.addObject("CategoryName", cateName);
		model.addObject("MinDateTime", formatedNowTime);
		model.addObject("MaxDateTime", formatedLimitTime);
		model.addObject("ManuList", manuList);
		model.addObject("ColorList", colorList);
		model.addObject("MultipartField", multi);
		return model;
	}
	
	@PostMapping("/products-management/create-product")
	public ModelAndView AddProductProcess(ModelAndView model, @ModelAttribute("ProductInputForm") Product productForm,
			@ModelAttribute("CheckExclusive") String exclusive, @ModelAttribute("CheckEnabled") String enabled, 
			@ModelAttribute("DiscountEnabled") String discountSetter, 
			@ModelAttribute("MutlipartField") MultiFieldsFilePathDTO filepath) 
	{
		RestTemplate resttemp = new RestTemplate();
		String findSpecificProductUrl = "http://localhost:8080/admin/get-specific-product";
		String checkProductExistUrl = "http://localhost:8080/admin/check-product-exist";
		String createProductUrl = "http://localhost:8080/admin/products-management/create-product";
		
		if(exclusive.contains("Exclusive")) productForm.setExclusive(true);
		if(exclusive.contains("NotExclusive")) productForm.setExclusive(false);
		
		if(enabled.contains("Enable")) productForm.setEnabled(true);
		if(enabled.contains("Disable")) productForm.setEnabled(false);
		
		if(discountSetter.contains("Enable")) productForm.getDiscount().setEnabled(true);
		if(discountSetter.contains("Disable"))  productForm.getDiscount().setEnabled(false);
		
		//System.out.println("Processing create product "+productForm.toString());
		
		int errorCount = 0;
		
		ResponseEntity<Product> getCompareProductResponse = 
		resttemp.postForEntity(findSpecificProductUrl, productForm.getProductID(), Product.class);
		Product checkProduct = getCompareProductResponse.getBody();
		
		if( checkProduct != null) 
		{
			System.out.println("Product ID already existed");
			errorCount +=1;
			String duplicateProductIDWarning = "Product ID already existed";
			model.addObject("dupProductID", duplicateProductIDWarning);
		}
		
		if(!productForm.getVariant().getProductOriginalIdentifier().isBlank()) {
			if(productForm.getVariant().getProductOriginalIdentifier().equals(productForm.getProductID())) 
			{
				System.out.println("You can not refer this product to itself");
				errorCount +=1;
				String selfReferredProductIDWarning = "You can not refer this product to itself";
				model.addObject("selfReferProductID", selfReferredProductIDWarning);
			}
			else 
			{
				ResponseEntity<Boolean> existProductResponse = 
				resttemp.postForEntity(checkProductExistUrl, 
				productForm.getVariant().getProductOriginalIdentifier(), Boolean.class);
				Boolean existProduct = existProductResponse.getBody();
				if(!existProduct) 
				{
					System.out.println("Original Product ID not found");
					errorCount +=1;
					String notKnownProductIDWarning = "Original Product ID not found";
					model.addObject("notKnownProductID", notKnownProductIDWarning);
				}
			}
		}
		
		boolean foundDup = false;
		if(productForm.getColorVariantInputList() != null && productForm.getColorVariantInputList().size() >1) 
		{
			Integer prevID = 0;
			Integer currID =0;
			for(ProductColorVariant colorVar: productForm.getColorVariantInputList()) 
			{
				if(prevID == 0) 
				{
					prevID =  colorVar.getColorID();
					currID = colorVar.getColorID();
					continue;
				}
				currID = colorVar.getColorID();
				if(currID == prevID) 
				{
					foundDup = true;
					break;
				}
				prevID = currID;
			
			}
			if(foundDup) 
			{
				System.out.println("Duplicating color found");
				errorCount +=1;
				String duplicateColorWarning = "Duplicating color";
				model.addObject("dupColor", duplicateColorWarning);
			}
		}
		
		if(productForm.getDiscount().getDiscountedPrice() != null && productForm.getDiscount().getDiscountPercent() != null 
		&& productForm.getDiscount().getStartDateInput() != null  && productForm.getDiscount().getEndDateInput() != null 
		&& !discountSetter.isEmpty()) 
		{
			if(productForm.getDiscount().getStartDateInput().isEqual(productForm.getDiscount().getEndDateInput())) 
			{
				System.out.println("Discount start date and end date cannot be the same");
				errorCount +=1;
				String startEqualsEnd = "Discount start date and end date cannot be the same";
				model.addObject("StartEqualsEnd", startEqualsEnd);
			}
			else if(productForm.getDiscount().getStartDateInput().isAfter(productForm.getDiscount().getEndDateInput())) 
			{
				System.out.println("Discount start date cannot be after to end date");
				errorCount +=1;
				String starAfterEnd = "Discount start date and end date cannot be the same";
				model.addObject("StarAfterEnd", starAfterEnd);
			}
		}
		
		int emptyCount = 0;
		boolean breakLoop= false;
		List<Integer> attrDeleteList = new ArrayList<Integer>();
		int itemNumber = 0;
		for(SpecSection spec : productForm.getSpecList()) 
		{
			for(Attributes attr: spec.attributes) 
			{
				if(attr.getValue().toString().isBlank()) 
				{
					if(emptyCount == 5) 
					{
						breakLoop = true;
						break;
					}
					emptyCount+=1;
					attrDeleteList.add(itemNumber);
					continue;
				}
				itemNumber +=1;
				if(breakLoop) break;
			}
		}
		
		if(emptyCount >=5) 
		{
			System.out.println("5 or more specification attributes empty");
			errorCount +=1;
			String over5AttrEmptyWarning = "You can not leave 5 or more specification attributes empty";
			model.addObject("over5AttrEmpty", over5AttrEmptyWarning);
		}
		
		if(errorCount >0 ) {
			String getCateBasedBrandUrl = "http://localhost:8080/admin/get-category-brands";
			
			LocalDateTime now = LocalDateTime.now();
			LocalDateTime limit = now.plusMonths(2);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");		
			
			String formatedNowTime = now.format(dtf);
			String formatedLimitTime = limit.format(dtf);
			
			ResponseEntity<Manufacturer[]> cateBrandsResponse = 
			resttemp.postForEntity(getCateBasedBrandUrl, productForm.getCategoryID(), Manufacturer[].class);
			List<Manufacturer> manuList = Arrays.asList(cateBrandsResponse.getBody());
			
			if(productForm.getColorVariantInputList().size() >0) 
			{
				String getAllColorUrl = "http://localhost:8080/admin/get-colors";
				ResponseEntity<Color[]> colorsResponse = 
				resttemp.getForEntity(getAllColorUrl, Color[].class);
				List<Color> colorList = Arrays.asList(colorsResponse.getBody());
				model.addObject("ColorList", colorList);
			}
			
			MultiFieldsFilePathDTO multi = new MultiFieldsFilePathDTO();
			model.addObject("ManuList", manuList);
			model.addObject("MinDateTime", formatedNowTime);
			model.addObject("MaxDateTime", formatedLimitTime);
			model.addObject("MultipartField", multi);
			model.addObject("ProductInputForm", productForm);
			model.setViewName("ProductCreate");
		}
		
		if(errorCount == 0) 
		{
			String dsSetter = discountSetter;
			MultiFieldsFilePathDTO files = filepath;
			String jsonToStringConvertUrl = "http://localhost:8080/admin/convert-to-json-string";
			
			String pID = productForm.getProductID();
			
			int count = 0;
			System.out.println("MultipartFile has "+ filepath.getImageFile().length+" file");
			for(MultipartFile filePart: filepath.getImageFile()) 
			{
					count +=1;
					String contentType = filePart.getContentType();
					System.out.println("Type of multipartFile file no. "+ count + " :"+ contentType);
					productForm.setImageType(contentType);
					String fileName = filePart.getOriginalFilename();
					System.out.println("Name of multipartFile file no. "+ count + " :"+ fileName);
					try {
						productForm.setImage(filePart.getInputStream().readAllBytes());
					} catch (IOException e) {
					e.printStackTrace();
					}
			}
		
		//productForm.setCategoryID(cateID);
		
		if(productForm.getArticle().getArticleUrl().isEmpty()) 
		{
			System.out.println("Article is null");
			productForm.setArticle(null);
		} 
		else productForm.getArticle().setProductID(pID);
				
		int count1= 0;
		if(filepath.getCameraShotsFile()[0].getOriginalFilename().isEmpty()) 
		{
			System.out.println("Camera shots is null");
			productForm.setCameraShots(null);
		} 
		
		if(filepath.getCameraShotsFile().length >0 && !filepath.getCameraShotsFile()[0].getOriginalFilename().isEmpty())
		{
			Set<ProductCameraShot> camSet = new HashSet<ProductCameraShot>();
			productForm.setCameraShots(camSet);
			System.out.println("MultipartFile for cameraShot has "+ filepath.getCameraShotsFile().length);
			for(MultipartFile cameraFile: filepath.getCameraShotsFile()) 
			{
				
				count1 +=1;
				String contentType = cameraFile.getContentType();
				System.out.println("Type of multipartFile file no. "+ count1 + " :"+ contentType);
				String fileName = cameraFile.getOriginalFilename();
				System.out.println("Name of multipartFile file no. "+ count1 + " :"+ fileName);
				ProductCameraShot camShot = new ProductCameraShot();
				try {
					camShot.setImage(cameraFile.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				camShot.setImageType(contentType);
				camShot.setProductID(pID);
				productForm.getCameraShots().add(camShot);
			}
			
		}
		
		if(productForm.getColorVariantInputList() !=null)
		{
			int countEl = 0;
			int countColor = 0;
			Set<ProductColorVariant> colorSet = new  HashSet<ProductColorVariant>();
			productForm.setColorVariant(colorSet);
			for(Iterator<ProductColorVariant> t = productForm.getColorVariantInputList().iterator(); t.hasNext();) 
			{
				ProductColorVariant el = t.next();
				countEl +=1;
				if(el.getFileDatas()[0].getOriginalFilename().isEmpty()) 
				{
					t.remove();
				}
				else 
				{
					System.out.println("MultipartFile of color no. "+ countEl+" has "+ el.getFileDatas().length);
					for(MultipartFile file: el.getFileDatas()) 
					{
						countColor +=1;
						String contentType = file.getContentType();
						System.out.println("Type of multipartFile file no. "+ countColor + " :"+ contentType);
						String fileName = file.getOriginalFilename();
						System.out.println("Name of multipartFile file no. "+ countColor + " :"+ fileName);
						ProductColorVariant toSaveEl = new ProductColorVariant();
						try {
							toSaveEl.setImage(file.getBytes());
						} catch (IOException e) {
							e.printStackTrace();
						}
						toSaveEl.setImageType(contentType);
						toSaveEl.setProductID(pID);
						toSaveEl.setColorID(el.getColorID());
						toSaveEl.setProductID(pID);
						productForm.getColorVariant().add(toSaveEl);
					}
				}
			}
			if(productForm.getColorVariant().size() ==0) productForm.setColorVariant(null);
			productForm.setColorVariantInputList(null);
		}
		else productForm.setColorVariant(null);
			
		if(productForm.getDiscount().getDiscountedPrice() == null || productForm.getDiscount().getDiscountPercent() == null 
				|| productForm.getDiscount().getStartDateInput() == null  || productForm.getDiscount().getEndDateInput() == null 
				 || discountSetter.isEmpty()) productForm.setDiscount(null);
		
		else if(productForm.getDiscount().getDiscountedPrice() != null && productForm.getDiscount().getDiscountPercent() != null 
				&& productForm.getDiscount().getStartDateInput() != null  && productForm.getDiscount().getEndDateInput() != null 
				&& !discountSetter.isEmpty()) 
		{ 
			productForm.getDiscount().setProductID(pID);
			String convertTimeUrl = "http://localhost:8080/admin/convert-date-time";
			
			LocalDateTime startConvert = 
			resttemp.postForObject(convertTimeUrl, productForm.getDiscount().getStartDateInput(), LocalDateTime.class);
			
			LocalDateTime endConvert =
			resttemp.postForObject(convertTimeUrl, productForm.getDiscount().getEndDateInput(), LocalDateTime.class);
			productForm.getDiscount().setEndDate(endConvert);
			productForm.getDiscount().setStartDate(startConvert);
		}
		
		int count2 = 0;
		if(filepath.getCameraShotsFile()[0].getOriginalFilename().isEmpty() ) {
			System.out.println("Feature is null");
			productForm.setFeatures(null);
		}
		else 
		{
			Set<ProductFeature> featureSet = new HashSet<ProductFeature>();
			productForm.setFeatures(featureSet);
			System.out.println("MultipartFile for feature has "+ filepath.getCameraShotsFile().length);
			for(MultipartFile featureFile: filepath.getCameraShotsFile()) 
			{
				count2 +=1;
				String contentType = featureFile.getContentType();
				System.out.println("Type of multipartFile file no. "+ count2 + " :"+ contentType);
				String fileName = featureFile.getOriginalFilename();
				System.out.println("Name of multipartFile file no. "+ count2 + " :"+ fileName);
				ProductFeature featureEl = new ProductFeature();
				try {
					featureEl.setImage(featureFile.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
				featureEl.setProductID(pID);
				featureEl.setImageType(contentType);
				productForm.getFeatures().add(featureEl);
				
			}
		}
			
		int count3 = 0;
		if(filepath.getUnboxingFile()[0].getOriginalFilename().isEmpty()) 
		{
			System.out.println("Unboxing is null");
			productForm.setUnboxing(null);
		}
		else 
		{
			Set<ProductUnboxingReview> unboxing = new HashSet<ProductUnboxingReview>();
			productForm.setUnboxing(unboxing);
			System.out.println("MultipartFile for unboxing has "+ filepath.getUnboxingFile().length);
			for(MultipartFile unboxFile: filepath.getUnboxingFile()) 
			{
				count3 +=1;
				String contentType = unboxFile.getContentType();
				System.out.println("Type of multipartFile file no. "+ count3 + " :"+ contentType);
				String fileName = unboxFile.getOriginalFilename();
				System.out.println("Name of multipartFile file no. "+ count3 + " :"+ fileName);
				ProductUnboxingReview unboxReview = new ProductUnboxingReview();
				try {
					unboxReview.setImage(unboxFile.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				unboxReview.setProductID(pID);
				unboxReview.setImageType(contentType);
				productForm.getUnboxing().add(unboxReview);
			}
			
		}
		
		if(productForm.getVariant().getProductOriginalIdentifier().isEmpty()) 
		{
			System.out.println("Variant is null");
			productForm.setVariant(null);
		}
		else productForm.getVariant().setProductVariantID(pID);

			
			if(emptyCount >0) {
				int delCount = 0;
				for(Integer delItem: attrDeleteList) 
				{
					boolean breakLoop1 = false;
				
					for(SpecSection section : productForm.specList) 
					{	
						for(Iterator<Attributes>  it = section.attributes.iterator(); it.hasNext();) 
						{
							Attributes item = it.next();
							if(delCount == delItem) 
							{
								it.remove();
								delCount = 0;
								breakLoop1 =true;
								break;
							}
							delCount +=1;
						}
						if(breakLoop1) break;	
					}
				}
			}
			for(SpecSection sector : productForm.specList) 
			{
				for(Attributes attr: sector.attributes) 
				{
					if(attr.getValue().toString().contains(";")) 
					{
						String[] split = attr.getValue().toString().split(";");
						attr.setValue(split);
					}
				}
			}
		
		ResponseEntity<String> jsonToStringResponse = 
		resttemp.postForEntity(jsonToStringConvertUrl, productForm.getSpecList(), String.class);
		String json = jsonToStringResponse.getBody();
		ProductSpecification specification = new ProductSpecification();
		productForm.setSpecifications(specification);
		productForm.getSpecifications().setProductSpecifications(json);
		productForm.getSpecifications().setProductID(pID);
		
		HttpHeaders headers = new HttpHeaders();
		List<MediaType> acceptHeads = new ArrayList<MediaType>();
		acceptHeads.add(MediaType.ALL);
		headers.setAccept(acceptHeads);
		
		HttpEntity<Product> requestEntity = new HttpEntity<>(productForm, headers);
		ResponseEntity<Product> prodUpdateResponse = 
		resttemp.postForEntity(createProductUrl, requestEntity, Product.class);

		Product createdProd = prodUpdateResponse.getBody();
		System.out.println("Product created details:"+ createdProd.toString());
		
		model.addObject("dupProductID", null);
		model.addObject("selfReferProductID", null);
		model.addObject("notKnownProductID", null);
		model.addObject("dupColor", null);
		model.addObject("over5AttrEmpty", null);
		model.addObject("StartEqualsEnd", null);
		model.addObject("StartAfterEnd", null);
		model.setViewName("redirect:/admin/products-management/view-products");
		}
		return model;
	}
	
	@GetMapping("/products-management/view-or-update-product/step-1/{proID}")
	public ModelAndView viewOrUpdateProductsStep1(ModelAndView model, @PathVariable("proID") String productIdentifier) {
	
		model.addObject("pID", productIdentifier);
		model.setViewName("ProductDetailsOrUpdate");
		return model;
	}
	
	@GetMapping("/products-management/view-or-update-product/step-2/{proID}")
	public ModelAndView viewOrUpdateProducts(ModelAndView model, @PathVariable("proID") String productIdentity, 
			@ModelAttribute("AdditionalColorVarNum") String additionColor) {
		
		RestTemplate resttemp = new RestTemplate();
		String getAllColorUrl = "http://localhost:8080/admin/get-colors";
		String productUpdateUrl = 
		"/admin/products-management/view-or-update-product/step-2/"+productIdentity;
		
		UriComponents uriComponents =
		UriComponentsBuilder.
		newInstance().scheme("http").host("localhost:8080").
		path(productUpdateUrl).query("AddColor={additionColor}").buildAndExpand(additionColor);
		//fromHttpUrl(productUpdateUrl)
		//.queryParam("AddColor", additionColor);
		
		System.out.println("Uri full path:"+ uriComponents.toString());
		
		ResponseEntity<Product> updatePrepareResponse =
		resttemp.getForEntity(uriComponents.toString(), Product.class);
		
		Product p = updatePrepareResponse.getBody();
		
		Integer additionalColor = Integer.valueOf(additionColor);
		//Product p = productRepo.findByProductID(productIdentity);

		MultiFieldsFilePathDTO multi = new MultiFieldsFilePathDTO();
		
		ResponseEntity<Color[]> allColors = 
		resttemp.getForEntity(getAllColorUrl, Color[].class);
		List<Color> colorList = Arrays.asList(allColors.getBody());
		
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime limit = now.plusMonths(2);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");		
		
		String formatedNowTime = now.format(dtf);
		String formatedLimitTime = limit.format(dtf);
		System.out.println("Before update:"+p.toString());
		model.addObject("ProductUpdateForm", p);
		model.addObject("MultiField", multi);
		model.addObject("ColorList", colorList);
		model.addObject("MinDateTime", formatedNowTime);
		model.addObject("MaxDateTime", formatedLimitTime);
		model.addObject("AdditionalColor", String.valueOf(additionalColor));
		model.setViewName("ProductDetailsOrUpdate");
		return model;
	}
	
	@GetMapping("/promotions-management/view-promotions")
	public ModelAndView showAllPromotions (ModelAndView model) 
	{
		RestTemplate resttemp = new RestTemplate();
		String resourceUrl = "http://localhost:8080/admin/promotions-management/view-promotions";
		ResponseEntity<PromoteCode[]> response = resttemp.getForEntity(resourceUrl, PromoteCode[].class);
		model.addObject("PromoteList", response.getBody());
		model.setViewName("PromoteView");
		return model;
	}
	
	@GetMapping("/promotions-management/create-promotion")
	public ModelAndView newPromotionInput (ModelAndView model) 
	{
		PromoteCode promotionCreateForm = new PromoteCode();
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
	public ModelAndView CreateANewPromotion (@ModelAttribute("PromoteCreateForm") PromoteCode promoteInputForm
	, @ModelAttribute("EnableCheck") String checkEnable, ModelAndView model) 
	{
		RestTemplate resttemp = new RestTemplate();
		String savePromotionUrl = "http://localhost:8080/admin/promotions-management/create-promotion";
		
		if(checkEnable.equals("Enable")) promoteInputForm.setEnabled(true);
		if(checkEnable.equals("Disable")) promoteInputForm.setEnabled(false);
		
		ResponseEntity<Object> response = 
				resttemp.postForEntity(savePromotionUrl, promoteInputForm, Object.class);
		
		if( (response.getBody() instanceof java.util.LinkedHashMap<?, ?>) ) 	
		{
			Map<String, String> errorRes = (Map<String,String>) response.getBody();
			LocalDateTime now = LocalDateTime.now();
			LocalDateTime limit = now.plusMonths(2);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");		
			
			String formatedNowTime = now.format(dtf);
			String formatedLimitTime = limit.format(dtf);
			model.addObject("PromoteNameDup", errorRes.get("PromoteNameDup"));
			model.addObject("StartSameAsEnd", errorRes.get("StartSameAsEnd"));
			model.addObject("StartIsAfterEnd", errorRes.get("StartIsAfterEnd"));
			model.addObject("MinDateTime", formatedNowTime);
			model.addObject("MaxDateTime", formatedLimitTime);
			model.addObject("PromoteForm", promoteInputForm);
			model.setViewName("PromoteAdd");
		}
		else if( response.getBody()==null ){		
			
			HttpStatus statusCode = response.getStatusCode();
			if(statusCode == HttpStatus.OK) 
			{
				System.out.println("Promotion has successfully been added");
				System.out.println("Promotion details:" +promoteInputForm);
			}
			model.addObject("PromoteNameDup", null);
			model.addObject("StartSameAsEnd", null);
			model.addObject("StartIsAfterEnd", null);
			model.setViewName("redirect:/admin/promotions-management/view-promotions");
		}	
		return model;
	}
	
	@GetMapping("/promotions-management/update-promotion/{promote}")
	public ModelAndView promotionUpdate (ModelAndView model, @PathVariable("promote") String promote) 
	{
		RestTemplate resttemp = new RestTemplate();
		String resourceUrl = "http://localhost:8080/admin/promotions-management/get-promotion/"
		+promote;
		ResponseEntity<PromoteCode> response = resttemp.getForEntity(resourceUrl, PromoteCode.class);
		PromoteCode promotionUpdateForm = new PromoteCode();
		promotionUpdateForm = response.getBody();
		
		HttpStatus step1StatusCode = response.getStatusCode();
		System.out.println("Status code at update promotion step 1"+ step1StatusCode.toString());
		
		promotionUpdateForm.setStartDateInput(promotionUpdateForm.getStartDate());
		promotionUpdateForm.setEndDateInput(promotionUpdateForm.getEndDate());
		
		LocalDateTime now = promotionUpdateForm.getStartDate();
		LocalDateTime limit = now.plusMonths(2);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");		
		
		String formatedNowTime = now.format(dtf);
		String formatedLimitTime = limit.format(dtf);
		
		model.addObject("MinDateTime", formatedNowTime);
		model.addObject("MaxDateTime", formatedLimitTime);
		model.addObject("PromoteUpdateForm", promotionUpdateForm);
		model.setViewName("PromoteUpdate");
		return model;

	}
	
	@PostMapping("/promotions-management/update-promotion")
	public ModelAndView promotionUpdateProcess (ModelAndView model, @ModelAttribute("PromoteUpdateForm") PromoteCode updateform, 
			@ModelAttribute("EnableCheck") String checkEnable) 
	{
		RestTemplate resttemp = new RestTemplate();
		String updatePromotionUrl = "http://localhost:8080/admin/promotions-management/update-promotion";
		
		if(checkEnable.equals("Enable")) updateform.setEnabled(true);
		if(checkEnable.equals("Disable")) updateform.setEnabled(false);
		
		ResponseEntity<Object> updatePromoteResponse = 
				resttemp.postForEntity(updatePromotionUrl, updateform, Object.class);
		
		if(updatePromoteResponse.getBody() instanceof java.util.LinkedHashMap<?, ?>) 
		{
			LocalDateTime now = LocalDateTime.now();
			LocalDateTime limit = now.plusMonths(2);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");		
			
			String formatedNowTime = now.format(dtf);
			String formatedLimitTime = limit.format(dtf);
			model.addObject("MinDateTime", formatedNowTime);
			model.addObject("MaxDateTime", formatedLimitTime);
			model.addObject("PromoteForm", updateform);
			model.setViewName("PromoteUpdate");
		}
		
		if(updatePromoteResponse.getBody() == null)
		{
			
			HttpStatus statusCode = updatePromoteResponse.getStatusCode();
			
			if(statusCode == HttpStatus.OK) 
			{

				System.out.println("Promotion has successfully been updated");
				System.out.println("Promotion details:" + updateform.toString());
			}
			
			model.addObject("StartSameAsEnd", null);
			model.addObject("StartIsAfterEnd", null);
			model.setViewName("redirect:/admin/promotions-management/view-promotions");
		}
		return model;

	}
}
