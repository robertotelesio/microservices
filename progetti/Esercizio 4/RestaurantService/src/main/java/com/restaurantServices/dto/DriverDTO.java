package com.restaurantServices.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class DriverDTO {
    private Long id;
    private String name;

   // private Set<RestaurantDTO> restaurantDTO = new HashSet<>();
}
