package com.myrestaurant.store.pizzarestaurantService.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
@Builder
@Table(name = "toppings")
public class Topping implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topping_id")
    private Long id;
    @NotBlank
    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "toppings")
    private Set<Pizza> pizzas = new HashSet<>();
}
