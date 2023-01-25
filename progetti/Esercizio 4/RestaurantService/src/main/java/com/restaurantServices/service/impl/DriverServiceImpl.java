package com.restaurantServices.service.impl;


import com.restaurantServices.dao.DriverRepo;
import com.restaurantServices.model.Driver;
import com.restaurantServices.service.DriverService;
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

