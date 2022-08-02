package com.group1.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.WebUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group1.dto.CartViewImageAttachment;
import com.group1.dto.ColorVariantUpdateDTO;
import com.group1.dto.ProductAddToCartForm;
import com.group1.dto.ProductList;
import com.group1.dto.CustomerViewProductDetails.ColorVariantDetails;
import com.group1.dto.CustomerViewProductDetails.GeneralProductDetails;
import com.group1.dto.CustomerViewProductDetails.ProductVariantDetails;
import com.group1.entities.product.Product;
import com.group1.entities.product.ProductColorVariant;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.group1.dto.CategoryList;
import com.group1.dto.ManufacturerList;

@Controller
public class CustomerController {

	Product productList;

	@GetMapping("/view-products/{pID}")
	public ModelAndView getAProductDetails(@PathVariable String pID, ModelAndView model) {
		RestTemplate resttemp = new RestTemplate();
		String viewProductDetailUrl = "http://localhost:8080/view-details-product/" + pID;

		ResponseEntity<GeneralProductDetails> productDetailsResponse = resttemp.getForEntity(viewProductDetailUrl,
				GeneralProductDetails.class);

		GeneralProductDetails finalProduct = productDetailsResponse.getBody();
		ProductAddToCartForm addToCartForm = new ProductAddToCartForm();

		if (finalProduct.getColorVariant().size() > 0) {
			List<ColorVariantUpdateDTO> colorVarUpdateList = new ArrayList<ColorVariantUpdateDTO>();

			for (ColorVariantDetails el : finalProduct.getColorVariant()) {
				if (colorVarUpdateList.size() == 0) {
					ColorVariantUpdateDTO colUpdateForm = new ColorVariantUpdateDTO();
					colUpdateForm.setForColorID(el.getColorID());
					colUpdateForm.setForColorName(el.getColorName());
					colorVarUpdateList.add(colUpdateForm);
					continue;
				}

				int countOccur = 0;
				if (colorVarUpdateList.size() > 0) {
					for (ColorVariantUpdateDTO obj : colorVarUpdateList) {
						if (obj.getForColorID() != el.getColorID()) {
							countOccur += 1;
						}
					}
					if (countOccur == colorVarUpdateList.size()) {
						ColorVariantUpdateDTO colUpdateForm = new ColorVariantUpdateDTO();
						colUpdateForm.setForColorID(el.getColorID());
						colUpdateForm.setForColorName(el.getColorName());
						colorVarUpdateList.add(colUpdateForm);
					}
				}
			}
			model.addObject("ProductColorList", colorVarUpdateList);
		}

		if (finalProduct.getOriginal() != null) {
			for (ProductVariantDetails it : finalProduct.getOriginal()) {

				if (!finalProduct.getProductID().equals(it.getProductOriginalIdentifier())) {
					String originID = it.getProductOriginalIdentifier();
					model.addObject("OriginalIdentifier", originID);
					break;
				}
			}
		}
		RestTemplate restTempCat = new RestTemplate();
		String resourceUrl2 = "http://localhost:8080/view-category";
		ResponseEntity<CategoryList[]> response2 = restTempCat.getForEntity(resourceUrl2, CategoryList[].class);
		List<CategoryList> categoryList = new ArrayList<CategoryList>();

		for (int i = 0; i < response2.getBody().length; i++) {
			categoryList.add(response2.getBody()[i]);
		}

		model.addObject("addCartForm", addToCartForm);
		model.setViewName("viewProductDetails");
		model.addObject("ProductDetails", finalProduct);
		model.addObject("cats", categoryList);
		return model;
	}

	@GetMapping("/view-cart")
	public ModelAndView viewProductCart(ModelAndView model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute(name = "CookieNull") String Cookienull, @ModelAttribute("newCookieValue") String newValue) {
		RestTemplate resttemp = new RestTemplate();
		Integer totalPrice = 0;
		Integer totalItem = 0;
		List<ProductAddToCartForm> itemsAsList = null;

		if (Cookienull.isBlank() && newValue.isBlank()) {
			Cookie cartItemCookie = WebUtils.getCookie(request, "cartItems");

			if (cartItemCookie == null) {
				model.addObject("CartItem", itemsAsList);
			} else {
				String cookieValue = null;
				try {
					cookieValue = URLDecoder.decode(cartItemCookie.getValue(), "UTF-8");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
				itemsAsList = new ArrayList<ProductAddToCartForm>();
				String[] items = cookieValue.split("-");
				for (String it : items) {
					if (it.contains(",")) {
						String[] attr = it.split(",");
						ProductAddToCartForm el = new ProductAddToCartForm();
						el.setProductID(attr[0]);

						el.setProductName(attr[1]);

						if (attr[2].equals("null"))
							el.setColorID(null);
						else
							el.setColorID(Integer.valueOf(attr[2]));

						if (attr[3].equals("null"))
							el.setColorName(null);
						else
							el.setColorName(attr[3]);

						el.setQuantity(Integer.valueOf(attr[4]));

						el.setPrice(Integer.valueOf(attr[5]));
						itemsAsList.add(el);
					}
				}
				List<CartViewImageAttachment> imageAttach = new ArrayList<CartViewImageAttachment>();
				for (ProductAddToCartForm item : itemsAsList) {
					System.out.println(item.toString());
					String getImageAttachmentUrl = "http://localhost:8080/get-image-attachment/";
					String proID = item.getProductID();
					getImageAttachmentUrl += proID;

					ResponseEntity<CartViewImageAttachment> imageResponse = resttemp.getForEntity(getImageAttachmentUrl,
							CartViewImageAttachment.class);

					CartViewImageAttachment finalImage = imageResponse.getBody();
					if (item.getColorID() != null)
						finalImage.setForColorID(item.getColorID());
					finalImage.setImageToShow(Base64.getEncoder().encodeToString(finalImage.getImage()));

					imageAttach.add(finalImage);
					totalPrice += item.getPrice() * item.getQuantity();
					totalItem += item.getQuantity();
				}
				try {
					cartItemCookie.setValue(URLEncoder.encode(cartItemCookie.getValue(), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				model.addObject("ImageAttach", imageAttach);
				model.addObject("CartItem", itemsAsList);
				model.addObject("CartItemTotalPrice", totalPrice);
				model.addObject("TotalItem", totalItem);

			}

		} else if (!Cookienull.isBlank() || !newValue.isBlank()) {
			if (Cookienull.equals("Null")) {
				Cookie cookie = new Cookie("cartItems", null);
				cookie.setMaxAge(0);
				cookie.setHttpOnly(false);
				cookie.setSecure(false);
				cookie.setPath("/");
				response.addCookie(cookie);
				model.addObject("CartItem", itemsAsList);
			} else if (!newValue.isBlank()) {
				Cookie cartCookie = WebUtils.getCookie(request, "cartItems");
				String cookieValue = newValue;

				itemsAsList = new ArrayList<ProductAddToCartForm>();
				String[] items = cookieValue.split("-");
				for (String it : items) {
					if (it.contains(",")) {
						String[] attr = it.split(",");
						ProductAddToCartForm el = new ProductAddToCartForm();
						el.setProductID(attr[0]);

						el.setProductName(attr[1]);

						if (attr[2].equals("null"))
							el.setColorID(null);
						else
							el.setColorID(Integer.valueOf(attr[2]));

						if (attr[3].equals("null"))
							el.setColorName(null);
						else
							el.setColorName(attr[3]);

						el.setQuantity(Integer.valueOf(attr[4]));

						el.setPrice(Integer.valueOf(attr[5]));
						itemsAsList.add(el);
					}
				}
				List<CartViewImageAttachment> imageAttach = new ArrayList<CartViewImageAttachment>();
				for (ProductAddToCartForm item : itemsAsList) {
					System.out.println(item.toString());
					String getImageAttachmentUrl = "http://localhost:8080/get-image-attachment/";
					String proID = item.getProductID();
					getImageAttachmentUrl += proID;

					ResponseEntity<CartViewImageAttachment> imageResponse = resttemp.getForEntity(getImageAttachmentUrl,
							CartViewImageAttachment.class);

					CartViewImageAttachment finalImage = imageResponse.getBody();
					if (item.getColorID() != null)
						finalImage.setForColorID(item.getColorID());
					finalImage.setImageToShow(Base64.getEncoder().encodeToString(finalImage.getImage()));

					imageAttach.add(finalImage);
					totalPrice += item.getPrice() * item.getQuantity();
					totalItem += item.getQuantity();
				}
				try {
					cookieValue = URLEncoder.encode(newValue, "UTF-8");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
				cartCookie.setValue(cookieValue);
				response.addCookie(cartCookie);
				model.addObject("ImageAttach", imageAttach);
				model.addObject("CartItem", itemsAsList);
				model.addObject("CartItemTotalPrice", totalPrice);
				model.addObject("TotalItem", totalItem);
			}
		}
		RestTemplate restTempCat = new RestTemplate();
		String resourceUrl2 = "http://localhost:8080/view-category";
		ResponseEntity<CategoryList[]> response2 = restTempCat.getForEntity(resourceUrl2, CategoryList[].class);
		List<CategoryList> categoryList = new ArrayList<CategoryList>();

		for (int i = 0; i < response2.getBody().length; i++) {
			categoryList.add(response2.getBody()[i]);
		}
		model.addObject("cats", categoryList);

		model.setViewName("ViewCart");
		return model;
	}
	
	@GetMapping("/delete-product-from-cart")
	public RedirectView deleteProductFromCart(ModelAndView model, @RequestParam("pID") String productID, 
			@RequestParam("colorID") Integer cID, HttpServletResponse response, HttpServletRequest request, 
			RedirectAttributes redir) 
	{
		RedirectView redirView = new RedirectView();
		redirView.setContextRelative(true);
		Cookie cartItems = WebUtils.getCookie(request, "cartItems");
		
		String cookieValue = null;
		List<ProductAddToCartForm> itemsAsList = null;
		try {
			cookieValue = URLDecoder.decode(cartItems.getValue(), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		itemsAsList = new ArrayList<ProductAddToCartForm>();
		String [] items = cookieValue.split("-");
		for(String it: items) 
		{
			if(it.contains(",")) 
			{
				String[] attr = it.split(",");
				ProductAddToCartForm el = new ProductAddToCartForm();
				el.setProductID(attr[0]);
				el.setProductName(attr[1]);
				if(attr[2].equals("null")) el.setColorID(null);
				else el.setColorID(Integer.valueOf(attr[2]));
				if(attr[3].equals("null")) el.setColorName(null);
				else el.setColorName(attr[3]);
				el.setQuantity(Integer.valueOf(attr[4]));
				el.setPrice(Integer.valueOf(attr[5]));
				itemsAsList.add(el);
			}
		}
		
		for(Iterator<ProductAddToCartForm> t = itemsAsList.iterator(); t.hasNext();) 
		{
			ProductAddToCartForm el = t.next();
			if(el.getProductID().equals(productID) && el.getColorID() == cID) 
			{
				System.out.println("Found product to delete");
				t.remove();
				break;
			}
		}
		
		if(itemsAsList.size() == 0) 
		{
			redir.addFlashAttribute("CookieNull", "Null");
		}
		else if(itemsAsList.size() >0) 
		{
			String newCookieValue = "";
			for(ProductAddToCartForm a: itemsAsList) 
			{
				String value = a.toString()+"-";
				newCookieValue += value;
			}
			redir.addFlashAttribute("newCookieValue", newCookieValue);
		}
		redirView.setUrl("view-cart");
		return redirView;
	}

	@GetMapping("/test")
	public ModelAndView gotoTestPage(ModelAndView model) {
		model.setViewName("TestPage");
		return model;
	}

	@GetMapping("/delete-cookie")
	public ModelAndView deleteCookie(ModelAndView model, HttpServletResponse response, HttpServletRequest request) {
		Cookie cookie = new Cookie("cartItems", null);
		cookie.setMaxAge(0);
		cookie.setHttpOnly(false);
		cookie.setSecure(false);
		cookie.setPath("/");
		response.addCookie(cookie);
		model.setViewName("TestPage");
		return model;
	}

	@PostMapping("/add-product-to-cart")
	public ModelAndView addProductToCart(ModelAndView model,
			@ModelAttribute("addCartForm") ProductAddToCartForm addForm, HttpServletRequest request,
			HttpServletResponse response) {
		RestTemplate resttemp = new RestTemplate();
		String getColorNameUrl = "http://localhost:8080/get-color-name/";

		System.out.println("Product add details:" + addForm.toString());
		List<ProductAddToCartForm> itemsAsList = null;
		Integer totalPrice = 0;
		Cookie cartItemCookie = WebUtils.getCookie(request, "cartItems");
		if (cartItemCookie == null) {
			totalPrice += addForm.getPrice() * addForm.getQuantity();
			if (addForm.getColorID() != null) {
				getColorNameUrl += addForm.getColorID();
				ResponseEntity<String> ColorNameResponse = resttemp.getForEntity(getColorNameUrl, String.class);
				String finalColorName = ColorNameResponse.getBody();
				addForm.setColorName(finalColorName);
			}

			Cookie cartItems = null;
			try {
				cartItems = new Cookie("cartItems", URLEncoder.encode(addForm.toString() + "-", "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cartItems.setMaxAge(60 * 60 * 24 * 30);
			cartItems.setHttpOnly(false);
			cartItems.setSecure(false);
			cartItems.setPath("/");
			response.addCookie(cartItems);
		} else {
			String cartItem = "";
			try {
				cartItem = URLDecoder.decode(cartItemCookie.getValue(), "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			itemsAsList = new ArrayList<ProductAddToCartForm>();
			String[] items = cartItem.split("-");
			for (String it : items) {
				if (it.contains(",")) {
					String[] attr = it.split(",");
					ProductAddToCartForm el = new ProductAddToCartForm();
					el.setProductID(attr[0]);

					el.setProductName(attr[1]);

					if (attr[2].equals("null"))
						el.setColorID(null);
					else
						el.setColorID(Integer.valueOf(attr[2]));

					if (attr[3].equals("null"))
						el.setColorName(null);
					else
						el.setColorName(attr[3]);

					el.setQuantity(Integer.valueOf(attr[4]));

					el.setPrice(Integer.valueOf(attr[5]));
					itemsAsList.add(el);
				}
			}

			boolean foundDup = false;
			for (ProductAddToCartForm element : itemsAsList) {
				if (addForm.getColorID() == null) {
					if (addForm.getProductID().equals(element.getProductID())) {
						element.setQuantity(element.getQuantity() + addForm.getQuantity());
						foundDup = true;
						break;
					}
				} else {
					if (addForm.getProductID().equals(element.getProductID())
							&& addForm.getColorID() == element.getColorID()) {
						element.setQuantity(element.getQuantity() + addForm.getQuantity());
						foundDup = true;
						break;
					}
				}
			}

			if (foundDup) {
				String newValue = "";
				for (ProductAddToCartForm el1 : itemsAsList) {
					newValue += el1.toString() + "-";
				}
				try {
					cartItemCookie.setValue(URLEncoder.encode(newValue, "UTF-8"));
				} catch (UnsupportedEncodingException e) {

					e.printStackTrace();
				}
				response.addCookie(cartItemCookie);
			} else {
				if (addForm.getColorID() != null) {
					getColorNameUrl += addForm.getColorID();
					ResponseEntity<String> ColorNameResponse = resttemp.getForEntity(getColorNameUrl, String.class);
					String finalColorName = ColorNameResponse.getBody();
					addForm.setColorName(finalColorName);
				}
				String cartItemDecode = "";

				try {
					cartItemDecode = URLDecoder.decode(cartItemCookie.getValue(), "UTF-8");
					cartItemCookie.setValue(URLEncoder.encode(cartItemDecode + "-" + addForm.toString(), "UTF-8"));
				} catch (UnsupportedEncodingException e) {

					e.printStackTrace();
				}
				response.addCookie(cartItemCookie);
			}
		}
		model.setViewName("TestPage");
		return model;
	}

	@GetMapping("/")
	public String redirect() {
		return "redirect:/view-products";
	}

	@GetMapping("/view-products")
	public ModelAndView showAllProducts(ModelAndView model, @RequestParam(required = false) Integer category,
			@RequestParam(required = false) Integer manufacturer, @RequestParam(required = false) String name) {
		RestTemplate resttemp = new RestTemplate();
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080")
				.path("/view-products");
		System.out.print("abe");

		if (category != null) {
			uriBuilder = uriBuilder.query("category=" + category);

			RestTemplate restTempManu = new RestTemplate();
			String resourceUrl3 = "http://localhost:8080/view-manufacturer?categoryId=" + category;
			ResponseEntity<ManufacturerList[]> response3 = restTempManu.getForEntity(resourceUrl3,
					ManufacturerList[].class);
			List<ManufacturerList> manufacturerList = new ArrayList<ManufacturerList>();

			for (int i = 0; i < response3.getBody().length; i++) {
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

		for (int i = 0; i < response.getBody().length; i++) {
			proList.add(response.getBody()[i]);
		}

		RestTemplate restTempCat = new RestTemplate();
		String resourceUrl2 = "http://localhost:8080/view-category";
		ResponseEntity<CategoryList[]> response2 = restTempCat.getForEntity(resourceUrl2, CategoryList[].class);
		List<CategoryList> categoryList = new ArrayList<CategoryList>();

		for (int i = 0; i < response2.getBody().length; i++) {
			categoryList.add(response2.getBody()[i]);
		}

		model.addObject("ProductList", proList);
		model.addObject("cats", categoryList);

		model.setViewName("index");
		return model;
	}
}
