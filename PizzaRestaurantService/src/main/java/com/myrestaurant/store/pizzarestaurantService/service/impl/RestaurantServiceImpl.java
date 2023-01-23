package com.myrestaurant.store.pizzarestaurantService.service.impl;

import com.myrestaurant.store.pizzarestaurantService.dao.PizzaRepo;
import com.myrestaurant.store.pizzarestaurantService.dao.RestaurantRepo;
import com.myrestaurant.store.pizzarestaurantService.model.Pizza;
import com.myrestaurant.store.pizzarestaurantService.model.Restaurant;
import com.myrestaurant.store.pizzarestaurantService.service.PizzaService;
import com.myrestaurant.store.pizzarestaurantService.service.RestaurantService;
import lombok.RequiredArgsConstructor;
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
