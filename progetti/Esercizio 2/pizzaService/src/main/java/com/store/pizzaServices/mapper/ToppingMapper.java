package com.store.pizzaServices.mapper;





import com.store.pizzaServices.dto.ToppingDTO;
import com.store.pizzaServices.model.Topping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ToppingMapper extends GenericMapper<Topping, ToppingDTO>{
}
