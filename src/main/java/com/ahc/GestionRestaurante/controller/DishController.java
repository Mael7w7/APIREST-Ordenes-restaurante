package com.ahc.GestionRestaurante.controller;

import com.ahc.GestionRestaurante.entities.DishEntity;
import com.ahc.GestionRestaurante.repositories.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor
public class DishController {
    private final DishRepository dishRepository;

    @PostMapping("/add")
    public DishEntity addDish(@RequestBody DishEntity dish) {
        return dishRepository.save(dish);
    }

    @GetMapping("/list")
    public List<DishEntity> getAllDishes() {
        return dishRepository.findAll();
    }
}
