package com.myrestaurant.store.pizzarestaurantService.controller.impl;

import com.myrestaurant.store.pizzarestaurantService.controller.DriverController;
import com.myrestaurant.store.pizzarestaurantService.controller.RestaurantController;
import com.myrestaurant.store.pizzarestaurantService.dto.DriverDTO;
import com.myrestaurant.store.pizzarestaurantService.dto.RestaurantDTO;
import com.myrestaurant.store.pizzarestaurantService.mapper.DriverMapper;
import com.myrestaurant.store.pizzarestaurantService.mapper.RestaurantMapper;
import com.myrestaurant.store.pizzarestaurantService.model.Driver;
import com.myrestaurant.store.pizzarestaurantService.model.Restaurant;
import com.myrestaurant.store.pizzarestaurantService.service.DriverService;
import com.myrestaurant.store.pizzarestaurantService.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantControllerImpl implements RestaurantController {



    private final RestaurantService restaurantService;

    private final RestaurantMapper restaurantMapper;


    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantDTO save(@RequestBody RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantMapper.asEntity(restaurantDTO);
        return restaurantMapper.asDTO(restaurantService.save(restaurant));
    }



    @Override
    @GetMapping("/{id}")
    public RestaurantDTO findById(@PathVariable("id") Long id) {
        Restaurant restaurant = restaurantService.findById(id).orElse(null);
        return restaurantMapper.asDTO(restaurant);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete( @PathVariable("id") Long id) {
        restaurantService.deleteByid(id);
    }

    @Override
    @GetMapping
    public List<RestaurantDTO> list() {
        return restaurantMapper.asDTOList(restaurantService.findAll());
    }

    @Override
    @PutMapping({"/{id}"})
    public RestaurantDTO update(@RequestBody RestaurantDTO restaurantDTO,@PathVariable("id") Long id) {
        Restaurant restaurant = restaurantMapper.asEntity(restaurantDTO);
        return restaurantMapper.asDTO(restaurantService.update(restaurant,id));

    }

    @Override
    @PostMapping("addPizzas")
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantDTO addPizzasToRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantMapper.asEntity(restaurantDTO);
        return restaurantMapper.asDTO(restaurantService.addPizzasToRestaurant(restaurant));
    }
}
