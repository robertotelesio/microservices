package com.restaurantServices.dto;

import com.restaurantServices.model.Driver;
import lombok.*;

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

//    private Set<Pizza> pizzas;
}
