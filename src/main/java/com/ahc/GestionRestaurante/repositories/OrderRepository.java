package com.ahc.GestionRestaurante.repositories;

import com.ahc.GestionRestaurante.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    // ✅ Cargar órdenes junto con platos y clientes
    @Query("SELECT DISTINCT o FROM OrderEntity o " +
            "LEFT JOIN FETCH o.dishes d " +
            "LEFT JOIN FETCH o.customer c")
    List<OrderEntity> findAllWithDishesAndCustomer();
}
