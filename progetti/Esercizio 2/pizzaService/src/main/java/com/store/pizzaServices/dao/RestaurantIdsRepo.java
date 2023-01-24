package com.store.pizzaServices.dao;

import com.store.pizzaServices.model.RestaurantIds;
import com.store.pizzaServices.model.RestaurantIdsPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantIdsRepo extends JpaRepository<RestaurantIds, RestaurantIdsPK> {

    List<RestaurantIds> findByRestaurantId(Long restaurantId);
}
