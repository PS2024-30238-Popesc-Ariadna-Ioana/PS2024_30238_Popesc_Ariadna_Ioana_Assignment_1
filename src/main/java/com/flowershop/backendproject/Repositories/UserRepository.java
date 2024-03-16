package com.flowershop.backendproject.Repositories;

import com.flowershop.backendproject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfata de repository pentru gestionarea entitatilor User.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Gaseste un utilizator dupa email si parola.
     *
     * @param email    Emailul utilizatorului
     * @param password Parola utilizatorului
     * @return Utilizatorul cu emailul si parola specificate
     */
    User findByEmailAndAndParola(String email, String password);
}
