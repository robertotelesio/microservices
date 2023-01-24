package com.myrestaurant.store.pizzarestaurantService.mapper;

import com.myrestaurant.store.pizzarestaurantService.dto.DriverDTO;
import com.myrestaurant.store.pizzarestaurantService.dto.RestaurantDTO;
import com.myrestaurant.store.pizzarestaurantService.model.Driver;
import com.myrestaurant.store.pizzarestaurantService.model.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverMapper extends GenericMapper<Driver, DriverDTO>{
}
