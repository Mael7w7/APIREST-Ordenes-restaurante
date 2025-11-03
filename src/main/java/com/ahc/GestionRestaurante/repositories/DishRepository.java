package com.ahc.GestionRestaurante.repositories;

import com.ahc.GestionRestaurante.entities.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<DishEntity, Long> {
}
