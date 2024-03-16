package com.flowershop.backendproject.Repositories;

import com.flowershop.backendproject.Entity.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfata de repository pentru gestionarea entitatilor de comenzi.
 */
public interface ComandaRepository extends JpaRepository<Comanda, Long> {

}
