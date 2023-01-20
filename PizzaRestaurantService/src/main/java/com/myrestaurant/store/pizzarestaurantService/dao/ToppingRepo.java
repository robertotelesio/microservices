package com.myrestaurant.store.pizzarestaurantService.dao;

import com.myrestaurant.store.pizzarestaurantService.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingRepo extends JpaRepository<Topping,Long> {
}
