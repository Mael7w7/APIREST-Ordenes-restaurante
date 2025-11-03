package com.ahc.GestionRestaurante.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderRequestDTO {
    private Long    id;
    private List<String> dishesName;

}
