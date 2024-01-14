package com.demo.restapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info= @Info(
				title = "Spring boot rest api documentation",
				description = "Spring boot rest api documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Rajesh",
						email = "test@testapi.com",
						url = "www.testapi.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "www.testapi.com"
				)
		)
)
public class DemoApplication {

	@Bean
	public ModelMapper modelMapper (){
	return new ModelMapper();
}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
