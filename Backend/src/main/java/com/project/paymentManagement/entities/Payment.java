package com.project.paymentManagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity @NoArgsConstructor@AllArgsConstructor @Getter @Setter @ToString @Builder
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private PaymentStatus status;
    @ManyToOne
    private Client client; //payment belong to a user
    private String file;

}
