package com.store.pizzaServices.service;



import com.store.pizzaServices.model.Pizza;

import java.util.List;


public interface PizzaService extends GenericService<Pizza, Long>{
    List<Pizza> findAll();


}
