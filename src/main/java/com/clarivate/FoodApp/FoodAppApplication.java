package com.clarivate.FoodApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

public class FoodAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodAppApplication.class, args);
	}

	@SuppressWarnings("rawtypes")
	List<VendorExtension> vendorExtensions = new ArrayList<VendorExtension>();

	Contact contact = new Contact("Shishir", "https://thelens.clarivate.com/", "shishir@gmail.com");

	ApiInfo apiInfo = new ApiInfo("Food App", "Food app project", "snapshot-0.01", "https://iamafoodblog.com/", contact,
			"www.foodblog.com", "terms and conditions", vendorExtensions);

	@Bean
	public Docket myDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.clarivate.FoodApp")).build().apiInfo(apiInfo);
	}
}
