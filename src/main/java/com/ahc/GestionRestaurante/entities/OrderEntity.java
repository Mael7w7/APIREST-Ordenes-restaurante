package com.ahc.GestionRestaurante.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private LocalDate date;

    //relacion Many TO ONE con CustomerEntity (Unidireccional)
    @ManyToOne
    @JoinColumn(name="id_customer",nullable=false)
    private CustomerEntity customer;



    @ManyToMany
    @JoinTable(
            name="order_dishes",
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<DishEntity> dishes;


}
