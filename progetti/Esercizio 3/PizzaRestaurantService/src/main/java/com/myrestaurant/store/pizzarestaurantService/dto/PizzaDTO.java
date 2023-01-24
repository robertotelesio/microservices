package com.myrestaurant.store.pizzarestaurantService.dto;

import com.myrestaurant.store.pizzarestaurantService.model.Topping;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class PizzaDTO {
    private Long id;
    private String name;
    private boolean favorite;
    private Set<ToppingDTO> toppings = new HashSet<>();
}
