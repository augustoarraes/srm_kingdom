package com.srmasset.api;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Conversão de Moeda")
                        .version("1.0")
                        .description("API que realiza conversões de moeda para diferentes produtos em tempo real."));
    }
}

