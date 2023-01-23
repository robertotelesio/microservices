package com.myrestaurant.store.pizzarestaurantService.controller;

import com.myrestaurant.store.pizzarestaurantService.dto.PizzaDTO;
import com.myrestaurant.store.pizzarestaurantService.dto.ToppingDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Topping API")
public interface ToppingController {

    @ApiOperation("Add new topping")
    public ToppingDTO save(@RequestBody ToppingDTO toppingDTO);

    @ApiOperation("find topping by ID")
    public ToppingDTO findById(@PathVariable("id")Long id);

    @ApiOperation("Delete topping by ID")
    public void delete(@PathVariable("id")Long id);

    @ApiOperation("find all topping")
    public List<ToppingDTO> list();

    @ApiOperation("Update topping")
    public ToppingDTO update(@RequestBody ToppingDTO topping, @PathVariable("id")Long id);



}
