package com.flowershop.backendproject.Repositories;

import com.flowershop.backendproject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAndAndParola(String email, String parola);
}
