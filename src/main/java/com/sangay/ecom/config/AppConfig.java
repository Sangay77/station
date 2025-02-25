package com.sangay.ecom.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {

        // Create the request factory
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

        // Set connection timeout (in milliseconds)
        factory.setConnectTimeout(30000); // 10 seconds

        // Set read timeout (in milliseconds)
        factory.setReadTimeout(45000); // 10 seconds

        // Create RestTemplate with the factory
        return new RestTemplate(factory);

    }
}
