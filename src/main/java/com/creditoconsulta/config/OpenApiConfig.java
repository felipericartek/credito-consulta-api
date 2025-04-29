package com.creditoconsulta.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Consulta de Créditos")
                        .description("API REST para consultar créditos constituídos por NFS-e ou número de crédito.")
                        .version("1.0.0"));
    }
}
