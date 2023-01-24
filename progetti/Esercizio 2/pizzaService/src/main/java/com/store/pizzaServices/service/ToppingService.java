package com.store.pizzaServices.service;


import com.store.pizzaServices.model.Topping;

import java.util.List;

public interface ToppingService extends GenericService<Topping, Long>{
    List<Topping> findAll();
}
