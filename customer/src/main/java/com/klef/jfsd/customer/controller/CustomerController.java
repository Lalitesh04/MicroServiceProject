package com.klef.jfsd.customer.controller;

import com.klef.jfsd.customer.dto.CustomerRegistrationRequest;
import com.klef.jfsd.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest) throws Exception {
        log.info("Registering new customer {}", customerRequest);
            customerService.registerCustomer(customerRequest);

    }
}
