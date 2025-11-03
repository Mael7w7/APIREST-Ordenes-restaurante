package com.ahc.GestionRestaurante.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "dish")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DishEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    private BigDecimal price;




}
