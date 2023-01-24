package com.restaurantServices.controller.impl;

import com.restaurantServices.controller.DriverController;
import com.restaurantServices.dto.DriverDTO;
import com.restaurantServices.mapper.DriverMapper;
import com.restaurantServices.model.Driver;
import com.restaurantServices.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverControllerImpl implements DriverController {




    private final DriverService driverService;

    private final DriverMapper driverMapper;


    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DriverDTO save(@RequestBody DriverDTO driverDTO) {
        Driver driver = driverMapper.asEntity(driverDTO);
        return driverMapper.asDTO(driverService.save(driver));
    }



    @Override
    @GetMapping("/{id}")
    public DriverDTO findById(@PathVariable("id") Long id) {
        Driver driver = driverService.findById(id).orElse(null);
        return driverMapper.asDTO(driver);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete( @PathVariable("id") Long id) {
        driverService.deleteByid(id);
    }

    @Override
    @GetMapping
    public List<DriverDTO> list() {
        return driverMapper.asDTOList(driverService.findAll());
    }

    @Override
    @PutMapping({"/{id}"})
    public DriverDTO update(@RequestBody DriverDTO driverDTO,@PathVariable("id") Long id) {
        Driver driver = driverMapper.asEntity(driverDTO);
        return driverMapper.asDTO(driverService.update(driver,id));

    }
}
