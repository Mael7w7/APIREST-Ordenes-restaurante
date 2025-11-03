package com.ahc.GestionRestaurante.service.implService;

import com.ahc.GestionRestaurante.dto.OrderDTO;
import com.ahc.GestionRestaurante.entities.CustomerEntity;
import com.ahc.GestionRestaurante.entities.DishEntity;
import com.ahc.GestionRestaurante.entities.OrderEntity;
import com.ahc.GestionRestaurante.repositories.CustomerRepository;
import com.ahc.GestionRestaurante.repositories.DishRepository;
import com.ahc.GestionRestaurante.repositories.OrderRepository;
import com.ahc.GestionRestaurante.service.Iservice.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class OrderService implements IOrderService {
    private final OrderRepository orders;
    private final CustomerRepository customerRepository;
    private final DishRepository dishRepository;

    @Override
    public OrderEntity addOrder(Long customerId, List<Long> dishIds) {
        CustomerEntity customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        List<DishEntity> dishes = dishRepository.findAllById(dishIds)
                .stream().collect(Collectors.toList());

        OrderEntity order = OrderEntity.builder()
                .customer(customer)
                .dishes(dishes)
                .date(LocalDate.now())
                .build();

        return orders.save(order);
    }


    @Override
    public List<OrderDTO> getOrders() {
        return orders.findAllWithDishesAndCustomer()
                .stream()
                .map(o -> new OrderDTO(
                        o.getId(),
                        o.getCustomer().getName(),
                        o.getDate(),
                        o.getDishes().stream()
                                .map(DishEntity::getName)
                                .collect(Collectors.toList())
                ))
                .toList();

    }

    @Override
    public void deleteOrder(Long id) {
        orders.deleteById(id);

    }
}
