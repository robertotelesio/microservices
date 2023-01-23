package com.myrestaurant.store.pizzarestaurantService.controller.impl;

import com.myrestaurant.store.pizzarestaurantService.controller.PizzaController;
import com.myrestaurant.store.pizzarestaurantService.dto.PizzaDTO;
import com.myrestaurant.store.pizzarestaurantService.mapper.PizzaMapper;
import com.myrestaurant.store.pizzarestaurantService.model.Pizza;
import com.myrestaurant.store.pizzarestaurantService.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pizzas")
@RequiredArgsConstructor
public class PizzaControllerImpl implements PizzaController {

    private final PizzaService pizzaService;

    private final PizzaMapper pizzaMapper;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PizzaDTO save(@RequestBody PizzaDTO pizzaDTO) {
        Pizza pizza = pizzaMapper.asEntity(pizzaDTO);
        return pizzaMapper.asDTO(pizzaService.save(pizza));
    }
//    stesso metodo
//    public PizzaDTO save(@RequestBody PizzaDTO pizzaDTO) {
//        Pizza pizza = pizzaMapper.asEntity(pizzaDTO);
//        Pizza saved = pizzaService.save(pizza);
//        PizzaDTO dto = pizzaMapper.asDTO(saved);
//        return dto;
//    }

    @Override
    @GetMapping("/{id}")
    public PizzaDTO findById(@PathVariable("id") Long id) {
        Pizza pizza = pizzaService.findById(id).orElse(null);
        return pizzaMapper.asDTO(pizza);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete( @PathVariable("id") Long id) {
    pizzaService.deleteByid(id);
    }

    @Override
    @GetMapping
    public List<PizzaDTO> list() {
        return pizzaMapper.asDTOList(pizzaService.findAll());
    }

    @Override
    @PutMapping({"/{id}"})
    public PizzaDTO update(@RequestBody PizzaDTO pizzaDTO,@PathVariable("id") Long id) {
        Pizza pizza = pizzaMapper.asEntity(pizzaDTO);
        return pizzaMapper.asDTO(pizzaService.update(pizza,id));

    }
}
