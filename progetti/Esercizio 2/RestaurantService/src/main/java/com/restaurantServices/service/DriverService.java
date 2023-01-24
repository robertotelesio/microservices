package com.restaurantServices.service;

import com.restaurantServices.model.Driver;

import java.util.List;


public interface DriverService extends GenericService<Driver, Long> {
    List<Driver> findAll();

//    Driver update(Driver entity, Long id);
}
