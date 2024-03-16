package com.flowershop.backendproject.Repositories;

import com.flowershop.backendproject.Entity.Produs;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfata de repository pentru gestionarea entitatilor de produse.
 */
public interface ProdusRepository extends JpaRepository<Produs, Long> {

}
