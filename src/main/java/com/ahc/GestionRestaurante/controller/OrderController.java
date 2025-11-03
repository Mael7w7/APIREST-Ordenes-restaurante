package com.ahc.GestionRestaurante.controller;

import com.ahc.GestionRestaurante.dto.OrderDTO;
import com.ahc.GestionRestaurante.entities.OrderEntity;
import com.ahc.GestionRestaurante.service.implService.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor

public class OrderController {
    private final OrderService orderService;

    @PostMapping("/add")
    public OrderEntity createOrder(@RequestParam Long customerId,
                                   @RequestParam List<Long> dishIds) {
        return orderService.addOrder(customerId, dishIds);
    }

    @GetMapping("/list")
    public List<OrderDTO> getAllOrders() {
        return orderService.getOrders();
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }


}
