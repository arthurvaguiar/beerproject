package com.beerproject.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.PathSelectors;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.beerproject"))
				.paths(PathSelectors.regex("/api.*"))
				.build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Beer Project",
				"API REST  de estilos de cerveja", 
				"1.0", 
				"Termos de Uso",
				new Contact(
						"Arthur Valentim", 
						"https://www.linkedin.com/in/arthur-valentim-de-aguiar-a9251867",
						"arthurvaguiar@gmail.com"),
				"Apache License Version 1.0", 
				"https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
			);
		return apiInfo;
	}

}
