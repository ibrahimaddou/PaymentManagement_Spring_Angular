package com.project.paymentManagement.Repository;

import com.project.paymentManagement.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, String> {
    Client findByCode(String code);
    List<Client> findByProgramId(String programId);
}
