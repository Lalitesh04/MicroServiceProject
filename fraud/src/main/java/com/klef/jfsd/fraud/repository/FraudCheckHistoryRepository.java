package com.klef.jfsd.fraud.repository;

import com.klef.jfsd.fraud.model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudCheckHistoryRepository  extends JpaRepository<FraudCheckHistory,Integer> {
}
