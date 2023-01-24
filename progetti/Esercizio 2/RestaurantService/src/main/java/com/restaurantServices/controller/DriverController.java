package com.restaurantServices.controller;

import com.restaurantServices.dto.DriverDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Driver API")
public interface DriverController {

    @ApiOperation("Add new Driver")
    public DriverDTO save(@RequestBody DriverDTO driverDTO);

    @ApiOperation("find driver by ID")
    public DriverDTO findById(@PathVariable("id")Long id);

    @ApiOperation("Delete by ID")
    public void delete(@PathVariable("id")Long id);

    @ApiOperation("find all Drivers")
    public List<DriverDTO> list();

    @ApiOperation("Update Driver")
    public DriverDTO update(@RequestBody DriverDTO driverDTO, @PathVariable("id")Long id);



}
