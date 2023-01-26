package com.restaurantServices.service;

import com.restaurantServices.dto.RestaurantIdsDTO;
import com.restaurantServices.model.Restaurant;

import java.util.List;


public interface RestaurantService extends GenericService<Restaurant, Long> {
    List<Restaurant> findAll();

    public void addPizzasToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOS);


}
