package com.store.pizzaServices.service.impl;

import com.store.pizzaServices.dao.PizzaRepo;
import com.store.pizzaServices.dao.RestaurantIdsRepo;
import com.store.pizzaServices.model.Pizza;

import com.store.pizzaServices.model.RestaurantIds;
import com.store.pizzaServices.service.PizzaService;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor  //genera i costruttori con variabili final
public class PizzaServiceImpl implements PizzaService {

    private final RestaurantIdsRepo restaurantIdsRepo;

    private final RabbitTemplate rabbitTemplate;
    private final PizzaRepo pizzaRepo;

    @Value("${app.rabbitmq.pizzas-added-routingkey}")
    private String addPizzasToRestaurantAddRoutingkey;

    @Override
    public Pizza save(Pizza entity) {
        return pizzaRepo.save(entity);
    }

    @Override
    public List<Pizza> save(List<Pizza> entities) {
        return (List<Pizza>) pizzaRepo.saveAll(entities);
    }

    @Override
    public void deleteByid(@PathVariable("id")Long id) {
        pizzaRepo.deleteById(id);

    }

    @Override
    public Optional<Pizza> findById(Long id) {
        return pizzaRepo.findById(id) ;
    }

    @Override
    public List<Pizza> findAll(){
        return pizzaRepo.findAll();
    }

    @Override
    public List<Pizza> findByRestaurantId(Long restaurantId) {
        List<RestaurantIds> restaurantIds = restaurantIdsRepo.findByRestaurantId(restaurantId);
        List<Pizza> pizzas = new ArrayList<>(restaurantIds.size());
        for (RestaurantIds el : restaurantIds){
            pizzas.add(pizzaRepo.findById(el.getPizzaId()).get());
        }
        return pizzas;
    }

    @Override
    public List<Pizza> addPizzasToRestaurant(List<RestaurantIds> restaurantIds) {
        List<RestaurantIds> result = restaurantIdsRepo.saveAll(restaurantIds);
        List<Pizza> pizzas = new ArrayList<>(result.size());
        for (RestaurantIds el : result){
            pizzas.add(pizzaRepo.findById(el.getPizzaId()).get());
        }
         restaurantIdsRepo.saveAll(restaurantIds);
        rabbitTemplate.convertAndSend("",addPizzasToRestaurantAddRoutingkey,pizzas);
                return pizzas;
    }


    @Override
    public Pizza update(Pizza entity, Long id) {
        Optional<Pizza> optional = findById(id);
        if(optional.isPresent()){
            return  save(entity);
        }
              return null  ;
    }
}
