package com.store.pizzaServices.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantIdsDTO {

        private Long restaurantId;


        private Long pizzaId;
    }

