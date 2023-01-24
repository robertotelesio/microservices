package com.myrestaurant.store.pizzarestaurantService.dao;

import com.myrestaurant.store.pizzarestaurantService.model.Driver;
import com.myrestaurant.store.pizzarestaurantService.model.Pizza;
import com.myrestaurant.store.pizzarestaurantService.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant,Long> {

    List<Restaurant> findAll();


}
