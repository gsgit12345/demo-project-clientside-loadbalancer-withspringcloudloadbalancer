package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeControllerApp {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeControllerApp.class,args);
        System.out.println("Employee service  started!");
    }
}
