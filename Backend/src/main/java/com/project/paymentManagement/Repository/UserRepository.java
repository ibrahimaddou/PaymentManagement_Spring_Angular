package com.project.paymentManagement.Repository;

import com.project.paymentManagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class UserRepository extends JpaRepository<User,String> {
    User findByCode(String code);

    List<User> findByProgramId(String programId);
}
