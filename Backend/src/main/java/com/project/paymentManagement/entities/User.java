package com.project.paymentManagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String code;
    private String programmeId;
    private String photo;

}
