package com.restaurantServices.service;

import com.restaurantServices.model.Restaurant;

import java.util.List;


public interface RestaurantService extends GenericService<Restaurant, Long> {
    List<Restaurant> findAll();

    Restaurant addPizzasToRestaurant(Restaurant restaurant);
}
