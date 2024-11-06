package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient
public class AddressApp {
    public static void main(String[] args) {
        SpringApplication.run(AddressApp.class,args);
        System.out.println("address app started!");
    }
}
