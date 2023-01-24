package com.myrestaurant.store.pizzarestaurantService.service.impl;

import com.myrestaurant.store.pizzarestaurantService.dao.DriverRepo;
import com.myrestaurant.store.pizzarestaurantService.model.Driver;
import com.myrestaurant.store.pizzarestaurantService.model.Pizza;
import com.myrestaurant.store.pizzarestaurantService.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepo repository;


    @Override
    public List<Driver> findAll() {
       return repository.findAll();
    }

    @Override
    public Driver save(Driver entity) {
        return repository.save(entity);
    }

    @Override
    public List<Driver> save(List<Driver> entities) {
        return (List<Driver>) repository.saveAll(entities);
    }

    @Override
    public void deleteByid(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Optional<Driver> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Driver update(Driver entity, Long id) {
        Optional<Driver> optional = findById(id);
        if(optional.isPresent()){
            return save(entity);
        }
        return null  ;
    }
}

