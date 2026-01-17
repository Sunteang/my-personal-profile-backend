package com.example.personalprofile.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI personalProfileOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Personal Profile API")
                        .description("API documentation for Personal Portfolio Website")
                        .version("1.0.0"));
    }
}
