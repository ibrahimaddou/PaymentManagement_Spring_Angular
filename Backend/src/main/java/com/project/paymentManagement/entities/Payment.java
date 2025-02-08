package com.project.paymentManagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity @AllArgsConstructor @Getter @Setter @ToString @Builder
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private PaymentStatus status;
    @ManyToMany
    private User user; //payment belong to a user

}
