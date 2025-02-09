package com.project.paymentManagement.Repository;

import com.project.paymentManagement.entities.Payment;
import com.project.paymentManagement.entities.PaymentStatus;
import com.project.paymentManagement.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByClientCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);


}