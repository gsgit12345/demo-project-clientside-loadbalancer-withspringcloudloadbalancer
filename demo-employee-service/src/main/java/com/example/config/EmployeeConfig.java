package com.example.config;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EmployeeConfig {

    public ModelMapper createModelMapper()
    {
        return new ModelMapper();
    }
    @LoadBalanced
    @Bean
    public RestTemplate createRestTemplate()
    {
        return new RestTemplate();
    }
}
