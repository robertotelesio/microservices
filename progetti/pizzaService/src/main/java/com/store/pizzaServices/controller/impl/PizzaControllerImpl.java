package com.store.pizzaServices.controller.impl;





import com.store.pizzaServices.controller.PizzaController;
import com.store.pizzaServices.dto.PizzaDTO;
import com.store.pizzaServices.mapper.PizzaMapper;
import com.store.pizzaServices.model.Pizza;

 import com.store.pizzaServices.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void delete(@PathVariable("id") Long id) {
        pizzaService.deleteByid(id);
    }

    @Override
    @GetMapping
    public List<PizzaDTO> list() {
        return pizzaMapper.asDTOList(pizzaService.findAll());
    }

    @Override
    @PutMapping({"/{id}"})
    public PizzaDTO update(@RequestBody PizzaDTO pizzaDTO, @PathVariable("id") Long id) {
        Pizza pizza = pizzaMapper.asEntity(pizzaDTO);
        return pizzaMapper.asDTO(pizzaService.update(pizza, id));

    }

    @Override
    public List<PizzaDTO> findByRestaurantId(Long restaurantId) {
        return null;
    }


}


