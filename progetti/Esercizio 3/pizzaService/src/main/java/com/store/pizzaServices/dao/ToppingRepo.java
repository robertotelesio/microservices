package com.store.pizzaServices.dao;

import com.store.pizzaServices.model.Pizza;
import com.store.pizzaServices.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ToppingRepo extends JpaRepository<Topping,Long> {

}
