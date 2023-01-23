package com.myrestaurant.store.pizzarestaurantService.service;

import com.myrestaurant.store.pizzarestaurantService.model.Pizza;

import java.util.List;


public interface PizzaService extends GenericService<Pizza, Long>{
    List<Pizza> findAll();
}
