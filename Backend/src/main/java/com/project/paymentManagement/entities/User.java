package com.project.paymentManagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.Builder;


@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
@Table(name = "users")  // Renommage de la table pour éviter les conflits le mot User réservé en sql /h2
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String code;
    private String programId;
    private String photo;

}
