package com.myrestaurant.store.pizzarestaurantService.service.impl;

import com.myrestaurant.store.pizzarestaurantService.dao.ToppingRepo;
import com.myrestaurant.store.pizzarestaurantService.model.Topping;
import com.myrestaurant.store.pizzarestaurantService.service.ToppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ToppingServiceImpl implements ToppingService {

    private final ToppingRepo repository;

    @Override
    public Topping save(Topping entity) {
        return  repository.save(entity);
    }

    @Override
    public List<Topping> save(List<Topping> entities) {
        return (List<Topping>) repository.saveAll(entities);
    }

    @Override
    public void deleteByid(Long id) {
        repository.deleteById(id);

    }
    @Override
    public List<Topping> findAll(){
        return repository.findAll();
    }

    @Override
    public Optional<Topping> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Topping update(Topping entity, Long id) {
            Optional<Topping> optional = findById(id);
            if(optional.isPresent()){
                return  save(entity);
            }
            return null  ;
        }
    }

