package com.restaurantServices.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PizzasToRestaurantAddedListener {
    @RabbitListener(queues = {"${app.rabbitmq.pizzas-added-routingkey}"})
    public void onPizzasToRestaurantAdded(List<Object> pizzas){
        log.info("Into onPizzasToRestaurantAdded method! --> Now do");

        for (Object pizza : pizzas){
            log.info("Pizza ->", pizza.toString());
        }
    }
}
