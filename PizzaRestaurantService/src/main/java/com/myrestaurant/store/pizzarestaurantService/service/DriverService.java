package com.myrestaurant.store.pizzarestaurantService.service;

import com.myrestaurant.store.pizzarestaurantService.model.Driver;
import com.myrestaurant.store.pizzarestaurantService.model.Pizza;
import com.myrestaurant.store.pizzarestaurantService.service.GenericService;

import java.util.List;


public interface DriverService extends GenericService<Driver, Long> {
    List<Driver> findAll();

//    Driver update(Driver entity, Long id);
}
