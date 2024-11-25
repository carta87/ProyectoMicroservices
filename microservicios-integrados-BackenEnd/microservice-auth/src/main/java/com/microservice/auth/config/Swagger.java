package com.microservice.auth.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.HttpHeaders;

@OpenAPIDefinition(
        info = @Info(
                title = "MICRO-SERVICE AUTH",
                description = "Alista los diferentes servios de login, registro, test",
                version = "1.0.0",
                contact = @Contact(
                        name = "Carlos Tafur",
                        url = "https://github.com/carta87",
                        email = "cart_albert@hotmail.com"
                ),
                license = @License(
                        name = "Standard Software Use License ",
                        url = "https://github.com/carta87"
                )
        ),
        servers = {
                @Server(
                        description = "DEV SERVER - API GATEWAY",
                        url = "http://localhost:8080/auth-micro"
                ),
                @Server(
                        description = "DEV SERVER - API GATEWAY - AZURE",
                        url = "https://web-microservicios-gateway-b8epcnfwd7c6evak.centralus-01.azurewebsites.net/auth-micro"
                ),
                @Server(
                        description = "DEV SERVER - MICRO-AUTH",
                        url = "http://localhost:8092"
                )
        },
        security = @SecurityRequirement(
                name = "Security Token"
        )
)
@SecurityScheme(
        name = "Security Token",
        description = "Access Token For My API",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class Swagger {
}
