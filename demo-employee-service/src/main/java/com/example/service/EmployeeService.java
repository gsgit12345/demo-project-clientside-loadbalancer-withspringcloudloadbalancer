package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepo;
import com.example.response.AddressResponse;
import com.example.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

        Optional<Employee> employee = employeeRepo.findById(id);
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        System.out.println("response is  =======================================" + employee.get().toString());
        AddressResponse addressResponse = restTemplate.getForObject("http://ADDRESS-SERVICE/addressservicectx/address/{id}", AddressResponse.class, id);
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }
}
