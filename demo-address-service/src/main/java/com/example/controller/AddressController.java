package com.example.controller;

import com.example.response.AddressResponse;
import com.example.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    public AddressService addressService;

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("id") int id) {
        AddressResponse addressResponse = addressService.findAddressByEmployeeId(id);

        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }
}
