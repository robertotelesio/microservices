package com.myrestaurant.store.pizzarestaurantService.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class ToppingDTO {
    private Long id;
    private String name;

}
