package com.klef.jfsd.fraud.controller;

import com.klef.jfsd.clients.fraud.dto.FraudCheckResponse;
import com.klef.jfsd.fraud.service.FraudCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudController(FraudCheckService checkService) {


    @GetMapping
    public FraudCheckResponse isFraudster(@RequestParam("customerId") Integer customerId){
        log.info("fraud check for CustomerId: {}", customerId);
        Boolean isFraudster= checkService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudster);
    }
}
