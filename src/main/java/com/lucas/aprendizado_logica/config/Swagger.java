package com.lucas.aprendizado_logica.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title="API de Lógica",
        version="1.0",
        description="API para aprendizagem de lógica de negócio."
    )
)
public class Swagger {
    
}
