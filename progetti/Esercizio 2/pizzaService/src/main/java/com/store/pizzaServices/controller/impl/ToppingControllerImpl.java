package com.store.pizzaServices.controller.impl;

import com.store.pizzaServices.controller.ToppingController;

import com.store.pizzaServices.dto.ToppingDTO;
import com.store.pizzaServices.mapper.ToppingMapper;
import com.store.pizzaServices.model.Topping;
import  com.store.pizzaServices.service.ToppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/toppings")
@RequiredArgsConstructor
public class ToppingControllerImpl implements ToppingController {

    private final ToppingService toppingService;

    private final ToppingMapper toppingMapper;
    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ToppingDTO save(@RequestBody ToppingDTO toppingDTO) {
        Topping topping = toppingMapper.asEntity(toppingDTO);
        return toppingMapper.asDTO(toppingService.save(topping));
    }


    @Override
    @GetMapping("/{id}")
    public ToppingDTO findById(@PathVariable("id") Long id) {
        Topping topping = toppingService.findById(id).orElse(null);
        return toppingMapper.asDTO(topping);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete( @PathVariable("id") Long id) {
        toppingService.deleteByid(id);
    }


    @Override
    @GetMapping
    public List<ToppingDTO> list() {
        return toppingMapper.asDTOList(toppingService.findAll());
    }


    @Override
    @PutMapping({"/{id}"})
    public ToppingDTO update(@RequestBody ToppingDTO toppingDTO,@PathVariable("id") Long id) {
        Topping topping= toppingMapper.asEntity(toppingDTO);
        return toppingMapper.asDTO(toppingService.update(topping,id));

    }
}
