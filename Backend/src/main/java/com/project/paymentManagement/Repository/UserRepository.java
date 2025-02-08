package com.project.paymentManagement.Repository;

import com.project.paymentManagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class UserRepository implements JpaRepository<User, String> {
    User findByCode(String code) {
        return null;
    }

    List<User> findByProgramId(String programId) {
        return null;
    }
}
