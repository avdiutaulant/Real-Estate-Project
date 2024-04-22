package com.example.security.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        //region Description of OpenAPI documentation
        info = @Info(
                contact = @Contact(
                        name = "Real Estate "
                ),
                description = "This is the OpenAPI documentation for the Real Estate project." +
                        " It provides comprehensive information about all the API endpoints," +
                        " request/response models, and error codes.",
                title = "Real Estate Project - Comprehensive OpenAPI Specification",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Local Development Environment - Accessible only within the local network",
                        url = "http://localhost:8080"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }

        //endregion
)

@SecurityScheme(
        //region Security Scheme Definition
        name = "bearerAuth",
        description = "This is the JWT-based authentication scheme used in the Real Estate project. " +
                "It uses the 'Bearer' scheme, where the JWT token " +
                "is sent in the Authorization header of HTTP requests.",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
        //endregion
)
public class OpenApiConfig {


}
