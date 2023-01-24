package com.restaurantServices.mapper;

import com.restaurantServices.dto.DriverDTO;
import com.restaurantServices.model.Driver;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverMapper extends GenericMapper<Driver, DriverDTO> {
}
