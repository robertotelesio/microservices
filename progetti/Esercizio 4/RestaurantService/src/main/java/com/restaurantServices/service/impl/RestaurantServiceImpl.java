package com.restaurantServices.service.impl;

import com.restaurantServices.dao.RestaurantRepo;
import com.restaurantServices.dto.RestaurantIdsDTO;
import com.restaurantServices.model.Restaurant;
import com.restaurantServices.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor  //genera i costruttori con variabili final
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepo repository;

    private final RabbitTemplate rabbitTemplate;

    @Value("${app.rabbitmq.add-pizzas-routingkey}")
    private String addPizzasToRestaurantRoutingKey;


    public void addPizzasToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOS){
        rabbitTemplate.convertAndSend("",addPizzasToRestaurantRoutingKey, restaurantIdsDTOS);
    }

    @Override
    public Restaurant save(Restaurant entity) {
        return repository.save(entity);
    }

    @Override
    public List<Restaurant> save(List<Restaurant> entities) {
        return (List<Restaurant>) repository.saveAll(entities);
    }

    @Override
    public void deleteByid(@PathVariable("id")Long id) {
        repository.deleteById(id);

    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return repository.findById(id) ;
    }

    @Override
    public List<Restaurant> findAll(){
        return repository.findAll();
    }




    @Override
    public Restaurant update(Restaurant entity, Long id) {
        Optional<Restaurant> optional = findById(id);
        if(optional.isPresent()){
            return  save(entity);
        }
              return null  ;
    }
}
