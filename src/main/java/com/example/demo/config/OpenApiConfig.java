// package com.example.demo.config;

// import io.swagger.v3.oas.annotations.OpenAPIDefinition;
// import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
// import io.swagger.v3.oas.annotations.info.Info;
// import io.swagger.v3.oas.annotations.security.SecurityScheme;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// @OpenAPIDefinition(
//         info = @Info(
//                 title = "Vehicle Service History API",
//                 version = "1.0",
//                 description = "Vehicle Service History Management System"
//         )
// )
// @SecurityScheme(
//         name = "bearerAuth",
//         type = SecuritySchemeType.HTTP,
//         scheme = "bearer",
//         bearerFormat = "JWT"
// )
// public class OpenApiConfig {


//     @Bean
//     public OpenAPI customOpenAPI() {

//         // 🔐 JWT Security Scheme
//         SecurityScheme jwtScheme = new SecurityScheme()
//                 .type(SecurityScheme.Type.HTTP)
//                 .scheme("bearer")
//                 .bearerFormat("JWT")
//                 .in(SecurityScheme.In.HEADER)
//                 .name("Authorization");

//         return new OpenAPI()
//                 // 🌍 Server config (your existing code)
//                 .servers(List.of(
//                         new Server()
//                                 .url("https://9139.408procr.amypo.ai/")
//                                 .description("Deployed Server")
//                 ))
//                 // 🔐 Add JWT scheme
//                 .components(new Components()
//                         .addSecuritySchemes("BearerAuth", jwtScheme)
//                 )
//                 // 🔐 Apply JWT globally
//                 .addSecurityItem(
//                         new SecurityRequirement().addList("BearerAuth")
//                 );
//     }
// }


package com.example.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Vehicle Service History API",
                version = "1.0",
                description = "Vehicle Service History Management"
        )
)
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class OpenApiConfig {
}
