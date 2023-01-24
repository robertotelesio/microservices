package com.store.pizzaServices.dto;

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
