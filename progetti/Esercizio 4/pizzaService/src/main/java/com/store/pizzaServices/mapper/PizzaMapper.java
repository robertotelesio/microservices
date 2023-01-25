package com.store.pizzaServices.mapper;

import com.store.pizzaServices.dto.PizzaDTO;
import com.store.pizzaServices.model.Pizza;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PizzaMapper extends GenericMapper<Pizza, PizzaDTO>{
}
