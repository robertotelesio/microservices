package com.restaurantServices.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class RestaurantIdsDTO {
    private Long restaurantId;
    private Long pizzaId;

}
