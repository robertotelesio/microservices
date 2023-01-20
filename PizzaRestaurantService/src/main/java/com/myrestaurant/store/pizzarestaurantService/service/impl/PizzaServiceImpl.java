package com.myrestaurant.store.pizzarestaurantService.service.impl;

import com.myrestaurant.store.pizzarestaurantService.dao.PizzaRepo;
import com.myrestaurant.store.pizzarestaurantService.model.Pizza;
import com.myrestaurant.store.pizzarestaurantService.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void deleteByid(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Optional<Pizza> findById(Long id) {
        return repository.findById(id) ;
    }

    public List<Pizza> findAll(){
        return (List<Pizza>) repository.findAll();
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
