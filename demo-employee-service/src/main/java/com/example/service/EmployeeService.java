package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepo;
import com.example.response.AddressResponse;
import com.example.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeRepo employeeRepo;
    @Autowired
    public ModelMapper modelMapper;
    @Autowired
    public RestTemplate restTemplate;
    @Autowired
    public LoadBalancerClient loadBalancerClient;

    public EmployeeResponse getEmployeeById(int id) {

        /*
        Optional<Employee> employee = employeeRepo.findById(id);
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        System.out.println("response is  =======================================" + employee.get().toString());
        AddressResponse addressResponse = restTemplate.getForObject("http://ADDRESS-SERVICE/addressservicectx/address/{id}", AddressResponse.class, id);
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
        comment this code will work
        */
        Optional<Employee> employee = employeeRepo.findById(id);
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        ServiceInstance serviceInstance = loadBalancerClient.choose("ADDRESS-SERVICE");
// Read URI and Add path that returns url
        String uri = serviceInstance.getUri().toString();
        System.out.println("uri is ::::"+uri);
// Get metadata
        String contextPath = serviceInstance.getMetadata().get("configPath");
        System.out.println("contextPath is ::::"+uri+":::path::"+uri + "address-service" + "/address/{id}");
// Make HTTP call and get Response data
            String servicePath=uri + "/address-service" + "/address/{id}";
            System.out.println("servicePath:::"+servicePath);
        AddressResponse addressResponse = restTemplate.getForObject(servicePath, AddressResponse.class, id);
        employeeResponse.setAddressResponse(addressResponse);
return  employeeResponse;
    }
}
