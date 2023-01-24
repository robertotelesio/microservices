package com.restaurantServices.controller.impl;

import com.restaurantServices.controller.RestaurantController;
import com.restaurantServices.dto.RestaurantDTO;
import com.restaurantServices.dto.RestaurantIdsDTO;
import com.restaurantServices.mapper.RestaurantMapper;
import com.restaurantServices.model.Restaurant;
import com.restaurantServices.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantControllerImpl implements RestaurantController {



    @Value("${app.pizza-service-url}")
    private String pizzaServiceUrl;

    private final RestaurantService restaurantService;

    private final RestaurantMapper restaurantMapper;


    @Override
    @PostMapping("/addPizzas")
    public List<Object> addPizzasToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOS) {
        RestTemplate restTemplate = new RestTemplate();
        return List.of(restTemplate.postForObject(pizzaServiceUrl,restaurantIdsDTOS,Object[].class));
    }

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
    @GetMapping("/pizzas/{restaurantId}")
    public List<Object> GetPizzasByRestaurantId(@PathVariable("restaurantId") Long restaurantId) {
        RestTemplate restTemplate = new RestTemplate();
        return List.of(Objects.requireNonNull(restTemplate.getForObject(pizzaServiceUrl + "/"+ restaurantId , Object[].class)));
    }


}
