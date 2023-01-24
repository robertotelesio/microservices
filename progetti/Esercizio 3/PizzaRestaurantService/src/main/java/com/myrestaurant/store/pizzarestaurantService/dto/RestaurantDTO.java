package com.myrestaurant.store.pizzarestaurantService.dto;

import com.myrestaurant.store.pizzarestaurantService.model.Driver;
import com.myrestaurant.store.pizzarestaurantService.model.Pizza;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class RestaurantDTO {
    private Long id;
    private String name;
    private String address;

    private String city;

    private Set<Driver> driverDTO;

    private Set<Pizza> pizzas;
}
