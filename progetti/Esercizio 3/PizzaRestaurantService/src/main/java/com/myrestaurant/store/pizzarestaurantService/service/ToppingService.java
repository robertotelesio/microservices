package com.myrestaurant.store.pizzarestaurantService.service;

import com.myrestaurant.store.pizzarestaurantService.model.Topping;

import java.util.List;

public interface ToppingService extends GenericService<Topping, Long>{
    List<Topping> findAll();
}
