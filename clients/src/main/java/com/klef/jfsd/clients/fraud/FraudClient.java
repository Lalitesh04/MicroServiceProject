package com.klef.jfsd.clients.fraud;

import com.klef.jfsd.clients.fraud.dto.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "fraud",path = "api/v1/fraud-check")
public interface FraudClient {

    @GetMapping
    public FraudCheckResponse isFraudster(@RequestParam("customerId") Integer customerId);

}
