package com.store.pizzaServices.service;



import com.store.pizzaServices.model.Pizza;
import com.store.pizzaServices.model.RestaurantIds;

import java.util.List;


public interface PizzaService extends GenericService<Pizza, Long>{
    List<Pizza> findAll();



    List<Pizza>findByRestaurantId(Long restaurantId);

    List<Pizza> addPizzasToRestaurant(List<RestaurantIds> restaurantIds);


}
