package com.myrestaurant.store.pizzarestaurantService.service.impl;

import com.myrestaurant.store.pizzarestaurantService.dao.PizzaRepo;
import com.myrestaurant.store.pizzarestaurantService.model.Pizza;
import com.myrestaurant.store.pizzarestaurantService.model.Restaurant;
import com.myrestaurant.store.pizzarestaurantService.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor  //genera i costruttori con variabili final
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepo repository;

    @Override
    public Pizza save(Pizza entity) {
        return repository.save(entity);
    }

    @Override
    public List<Pizza> save(List<Pizza> entities) {
        return (List<Pizza>) repository.saveAll(entities);
    }

    @Override
    public void deleteByid(@PathVariable("id")Long id) {
        repository.deleteById(id);

    }

    @Override
    public Optional<Pizza> findById(Long id) {
        return repository.findById(id) ;
    }

    @Override
    public List<Pizza> findAll(){
        return repository.findAll();
    }

    @Override
    public List<Pizza> findByRestaurantId(Long restaurantId) {
        List<Pizza> pizzas = repository.findByRestaurantsIn(
                List.of(Restaurant
                        .builder()
                        .id(restaurantId)
                        .build())
        );
        return null;
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
