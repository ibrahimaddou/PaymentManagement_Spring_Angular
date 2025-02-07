package com.project.paymentManagement.entities;

import java.time.LocalDate;

public class Payment {
    private Long id;
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private PaymentStatus status;

    private User user; //payment belong to a user

}
