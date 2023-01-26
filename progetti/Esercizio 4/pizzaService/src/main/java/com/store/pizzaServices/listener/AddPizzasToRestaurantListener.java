package com.store.pizzaServices.listener;

import com.store.pizzaServices.dto.RestaurantIdsDTO;
import com.store.pizzaServices.mapper.RestaurantIdsMapper;
import com.store.pizzaServices.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddPizzasToRestaurantListener {

    private final PizzaService pizzaService;
    private final RestaurantIdsMapper restaurantIdsMapper;

    @RabbitListener(queues = {"${app.rabbitmq.add-pizzas-routingkey}"})
    public void addPizzasToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOS){
        pizzaService.addPizzasToRestaurant(restaurantIdsMapper.asEntityList(restaurantIdsDTOS));
    }
}
