package com.group1.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.transform.Source;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class HtmlMessageConverterConfig {

	@Bean
	public RestTemplate restTemplate() {
	   final RestTemplate restTemplate = new RestTemplate();
	   List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
	   //ObjectMapper mapper = new ObjectMapper();
	   //mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
	   MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	   //converter.setObjectMapper(mapper);
	   converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
	   ResourceHttpMessageConverter converter1  = new ResourceHttpMessageConverter();
	   converter1.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
	   ByteArrayHttpMessageConverter converter2 = new ByteArrayHttpMessageConverter();
	   converter2.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
	   AllEncompassingFormHttpMessageConverter converter3 = new AllEncompassingFormHttpMessageConverter();
	   converter3.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
	   FormHttpMessageConverter converter4 = new FormHttpMessageConverter();
	   converter4.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
	   SourceHttpMessageConverter<Source> converter5 = new SourceHttpMessageConverter<Source>();
	   converter5.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
	   StringHttpMessageConverter converter6 = new StringHttpMessageConverter();
	   converter6.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
	   messageConverters.add(converter1);
	   messageConverters.add(converter);
	   messageConverters.add(converter2);
	   messageConverters.add(converter3);
	   messageConverters.add(converter4);
	   messageConverters.add(converter5);
	   messageConverters.add(converter6);
	   restTemplate.setMessageConverters(messageConverters);

	   return restTemplate;
	}
	
}
