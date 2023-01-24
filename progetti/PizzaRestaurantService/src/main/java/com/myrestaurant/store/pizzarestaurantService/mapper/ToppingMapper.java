package com.myrestaurant.store.pizzarestaurantService.mapper;


import com.myrestaurant.store.pizzarestaurantService.dto.ToppingDTO;

import com.myrestaurant.store.pizzarestaurantService.model.Topping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ToppingMapper extends GenericMapper<Topping, ToppingDTO>{
}
