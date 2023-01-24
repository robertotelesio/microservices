package com.myrestaurant.store.pizzarestaurantService.controller.impl;

import com.myrestaurant.store.pizzarestaurantService.controller.ToppingController;
import com.myrestaurant.store.pizzarestaurantService.dto.PizzaDTO;
import com.myrestaurant.store.pizzarestaurantService.dto.ToppingDTO;
import com.myrestaurant.store.pizzarestaurantService.mapper.PizzaMapper;
import com.myrestaurant.store.pizzarestaurantService.mapper.ToppingMapper;
import com.myrestaurant.store.pizzarestaurantService.model.Pizza;
import com.myrestaurant.store.pizzarestaurantService.model.Topping;
import com.myrestaurant.store.pizzarestaurantService.service.PizzaService;
import com.myrestaurant.store.pizzarestaurantService.service.ToppingService;
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
