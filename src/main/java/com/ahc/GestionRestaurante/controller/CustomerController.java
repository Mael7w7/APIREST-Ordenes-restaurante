package com.ahc.GestionRestaurante.controller;

import com.ahc.GestionRestaurante.entities.CustomerEntity;
import com.ahc.GestionRestaurante.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerRepository customerRepository;

    @PostMapping("/add")
    public CustomerEntity addCustomer(@RequestBody CustomerEntity customer) {
        return customerRepository.save(customer);
    }

}
