package com.ahc.GestionRestaurante.repositories;

import com.ahc.GestionRestaurante.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
