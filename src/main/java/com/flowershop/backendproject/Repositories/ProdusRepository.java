package com.flowershop.backendproject.Repositories;

import com.flowershop.backendproject.Entity.Produs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdusRepository extends JpaRepository<Produs, Long> {

}
