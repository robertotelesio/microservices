package com.restaurantServices.controller;

import com.restaurantServices.dto.RestaurantDTO;
import com.restaurantServices.dto.RestaurantIdsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Api(tags = "restaurant API")
public interface RestaurantController {



    @PostMapping("/addPizzas")
    @ResponseStatus(HttpStatus.OK)
    List<Object> addPizzaToRestaurant(@RequestBody List<RestaurantIdsDTO> restaurantIdsDTOS);

    @ApiOperation("Add new Restaurant")
    public RestaurantDTO save(@RequestBody RestaurantDTO restaurantDTO);

    @ApiOperation("find Restaurant by ID")
    public RestaurantDTO findById(@PathVariable("id")Long id);

    @ApiOperation("Delete by ID")
    public void delete(@PathVariable("id")Long id);

    @ApiOperation("find all Restaurant")
    public List<RestaurantDTO> list();

    @ApiOperation("Update Restaurant")
    public RestaurantDTO update(@RequestBody RestaurantDTO restaurantDTO, @PathVariable("id")Long id);



    @ApiOperation("get pizzas by Restaurant")
    public List<Object>GetPizzasByRestaurantId(@RequestBody Long restaurantId);
}

