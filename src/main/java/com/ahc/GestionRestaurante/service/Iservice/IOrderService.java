package com.ahc.GestionRestaurante.service.Iservice;

import com.ahc.GestionRestaurante.dto.OrderDTO;
import com.ahc.GestionRestaurante.entities.OrderEntity;

import java.util.List;

public interface IOrderService {
    OrderEntity addOrder(Long customerId, List<Long> dishIds);
    List<OrderDTO> getOrders();
    void deleteOrder(Long id);
}
