package com.myrestaurant.store.pizzarestaurantService.mapper;

import com.myrestaurant.store.pizzarestaurantService.dto.PizzaDTO;
import com.myrestaurant.store.pizzarestaurantService.dto.RestaurantDTO;
import com.myrestaurant.store.pizzarestaurantService.model.Pizza;
import com.myrestaurant.store.pizzarestaurantService.model.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper extends GenericMapper<Restaurant, RestaurantDTO>{
}
