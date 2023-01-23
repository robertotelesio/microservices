package com.myrestaurant.store.pizzarestaurantService.service;

import com.myrestaurant.store.pizzarestaurantService.model.Driver;
import com.myrestaurant.store.pizzarestaurantService.model.Pizza;
import com.myrestaurant.store.pizzarestaurantService.model.Restaurant;
import com.myrestaurant.store.pizzarestaurantService.service.GenericService;

import java.util.List;


public interface RestaurantService extends GenericService<Restaurant, Long> {
    List<Restaurant> findAll();
}
