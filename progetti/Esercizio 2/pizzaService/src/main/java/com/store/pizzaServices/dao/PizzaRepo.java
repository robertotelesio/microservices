package com.store.pizzaServices.dao;

import com.store.pizzaServices.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepo extends JpaRepository<Pizza,Long> {



}
