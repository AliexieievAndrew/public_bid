package com.example.demo.config;

import com.example.demo.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig  {

    @Bean
    public RestClient getRestClient() {
        return new RestClient();
    }
}
