package com.klef.jfsd.fraud.service;

import com.klef.jfsd.fraud.model.FraudCheckHistory;
import com.klef.jfsd.fraud.repository.FraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public record FraudCheckService(FraudCheckHistoryRepository repository) {

    public boolean isFraudulentCustomer(Integer customerId) {

        repository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .build()
        );
        return  false;
    }
}
