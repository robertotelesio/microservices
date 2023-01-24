package com.restaurantServices.mapper;


import com.restaurantServices.dto.RestaurantDTO;
import com.restaurantServices.model.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper extends GenericMapper<Restaurant, RestaurantDTO> {
}
