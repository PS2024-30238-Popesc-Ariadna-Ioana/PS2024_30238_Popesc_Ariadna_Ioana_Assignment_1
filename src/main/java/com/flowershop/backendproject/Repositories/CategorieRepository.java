package com.flowershop.backendproject.Repositories;

import com.flowershop.backendproject.Entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfata de repository pentru gestionarea entitatilor de categorii.
 */
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
