package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        // 🔐 JWT Security Scheme
        SecurityScheme jwtScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER)
                .name("Authorization");

        return new OpenAPI()
                // 🌍 Server config (your existing code)
                .servers(List.of(
                        new Server()
                                .url("https://9139.408procr.amypo.ai/")
                                .description("Deployed Server")
                ))
                // 🔐 Add JWT scheme
                .components(new Components()
                        .addSecuritySchemes("BearerAuth", jwtScheme)
                )
                // 🔐 Apply JWT globally
                .addSecurityItem(
                        new SecurityRequirement().addList("BearerAuth")
                );
    }
}
