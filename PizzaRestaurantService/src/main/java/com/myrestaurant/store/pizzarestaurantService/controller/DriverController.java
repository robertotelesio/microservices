package com.myrestaurant.store.pizzarestaurantService.controller;

import com.myrestaurant.store.pizzarestaurantService.dto.DriverDTO;
import com.myrestaurant.store.pizzarestaurantService.dto.PizzaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Driver API")
public interface DriverController {

    @ApiOperation("Add new pizza")
    public DriverDTO save(@RequestBody DriverDTO driverDTO);

    @ApiOperation("find pizza by ID")
    public DriverDTO findById(@PathVariable("id")Long id);

    @ApiOperation("Delete by ID")
    public void delete(@PathVariable("id")Long id);

    @ApiOperation("find all pizza")
    public List<DriverDTO> list();

    @ApiOperation("Update Pizza")
    public DriverDTO update(@RequestBody DriverDTO driverDTO, @PathVariable("id")Long id);



}
