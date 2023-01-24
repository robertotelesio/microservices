package com.myrestaurant.store.pizzarestaurantService.mapper;

import com.myrestaurant.store.pizzarestaurantService.dto.PizzaDTO;
import com.myrestaurant.store.pizzarestaurantService.model.Pizza;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PizzaMapper extends GenericMapper<Pizza, PizzaDTO>{
}
