package com.myrestaurant.store.RestaurantService.controller.impl;

import com.myrestaurant.store.RestaurantService.controller.RestaurantController;
import com.myrestaurant.store.RestaurantService.dto.RestaurantDTO;
import com.myrestaurant.store.RestaurantService.dto.RestaurantIdsDTO;
import com.myrestaurant.store.RestaurantService.mapper.RestaurantMapper;
import com.myrestaurant.store.RestaurantService.model.Restaurant;
import com.myrestaurant.store.RestaurantService.service.RestaurantService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RequestMapping("/restaurants")
@RestController
@RequiredArgsConstructor
public class RestaurantControllerImpl implements RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;

    @Value("${app.pizza-service-url}")
    private String pizzaServiceUrl;

    @Override
    @PostMapping("/addPizzas")
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "addPizzasToRestaurant", fallbackMethod = "addPizzasToRestaurantFallback")
    @Retry(name = "retryAddPizzasToRestaurant")
    public List<Object> addPizzasToRestaurant(@RequestBody List<RestaurantIdsDTO> restaurantIdsDTOS) {
        // Chiamata sincrona
        RestTemplate restTemplate = new RestTemplate();
        List<Object> result = List.of(Objects.requireNonNull(restTemplate.postForObject(pizzaServiceUrl, restaurantIdsDTOS, Object[].class)));
        // chiamata asincrona
        // restaurantService.addPizzasToRestaurant(restaurantIdsDTOS);
        return List.of("Pizzas added to restaurant.");
    }

    @Override
    @GetMapping("/pizzas/{restaurantId}")
    public List<Object> getPizzasByRestaurantId(@PathVariable("restaurantId") Long restaurantId) {
        RestTemplate restTemplate = new RestTemplate();
        List<Object> result = List.of(Objects.requireNonNull(restTemplate.getForObject(pizzaServiceUrl + "/" + restaurantId, Object[].class)));
        return result;
    }

    @Override
    @PostMapping(path = {"/", "/create"})
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantDTO save(@RequestBody RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantMapper.asEntity(restaurantDTO);
        return restaurantMapper.asDTO(restaurantService.save(restaurant));
    }

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public RestaurantDTO findById(@PathVariable("id") Long id) {
        Restaurant restaurant = restaurantService.findById(id).orElse(null);
        return restaurantMapper.asDTO(restaurant);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        restaurantService.deleteById(id);
    }

    @Override
    @GetMapping

    public List<RestaurantDTO> findAllRestaurants() {
        return restaurantMapper.asDTOList(restaurantService.findAll());
    }


    @Override
    @PutMapping("/{id}")
    public RestaurantDTO update(@RequestBody RestaurantDTO restaurantDTO, @PathVariable("id") Long id) {
        Restaurant restaurant = restaurantMapper.asEntity(restaurantDTO);
        return restaurantMapper.asDTO(restaurantService.update(restaurant, id));
    }

    @Override
    @PostMapping("/addPizzas/async")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Object> addPizzaToRestaurantASync(@RequestBody List<RestaurantIdsDTO> restaurantIdsDTOS) {
        restaurantService.addPizzasToRestaurant(restaurantIdsDTOS);
        return List.of("Pizzas in queue to be added to the restaurant.");
    }

    @Override
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public List<Object> addPizzasToRestaurantFallback(Exception e) {
        return List.of("Error on addPizzasToRestaurantFallback.");
    }

    @Override
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public List<Object> getPizzasToRestaurantFallback(Exception e) {
        return List.of("Error on addPizzasToRestaurantFallback.");
    }


}