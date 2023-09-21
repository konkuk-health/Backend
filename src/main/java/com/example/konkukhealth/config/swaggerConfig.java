package com.example.konkukhealth.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class swaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("springshop-public")
                .pathsToMatch("/**")
                .build();
    }
    /*
    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("springshop-admin")
                .pathsToMatch("/admin/**")
                .addOpenApiMethodFilter(method -> method.isAnnotationPresent(Admin.class))
                .build();
    }

     */
}
