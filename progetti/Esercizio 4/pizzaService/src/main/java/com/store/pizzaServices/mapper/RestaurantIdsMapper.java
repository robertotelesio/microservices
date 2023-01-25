package com.store.pizzaServices.mapper;

import com.store.pizzaServices.dto.PizzaDTO;
import com.store.pizzaServices.dto.RestaurantIdsDTO;
import com.store.pizzaServices.model.Pizza;
import com.store.pizzaServices.model.RestaurantIds;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantIdsMapper extends GenericMapper<RestaurantIds, RestaurantIdsDTO>{
}
