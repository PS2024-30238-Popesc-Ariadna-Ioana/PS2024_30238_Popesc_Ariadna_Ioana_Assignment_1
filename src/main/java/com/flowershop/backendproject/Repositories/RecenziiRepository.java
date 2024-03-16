package com.flowershop.backendproject.Repositories;

import com.flowershop.backendproject.Entity.Recenzii;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfata de repository pentru gestionarea entitatilor de recenzii.
 */
public interface RecenziiRepository extends JpaRepository<Recenzii, Long> {
}
