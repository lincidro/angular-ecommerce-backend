package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

		HttpMethod[] unsupportedActions = {HttpMethod.DELETE, HttpMethod.POST, HttpMethod.PUT};
		
		//Deshabilitar metodos http para Product
		config.getExposureConfiguration()
			.forDomainType(Product.class)
			.withItemExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedActions))
			.withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedActions));

		//Deshabilitar metodos http para ProductCategory
		config.getExposureConfiguration()
			.forDomainType(ProductCategory.class)
			.withItemExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedActions))
			.withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedActions));
	}
}
