package com.sp.eshopping_payment_service.repository;

import com.sp.eshopping_payment_service.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long> {
    Optional<TransactionDetails> findByOrderId(long orderId);
}
