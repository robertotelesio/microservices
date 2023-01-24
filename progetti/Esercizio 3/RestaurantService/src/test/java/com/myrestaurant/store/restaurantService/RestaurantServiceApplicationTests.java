package com.myrestaurant.store.restaurantService;

import com.restaurantServices.RestaurantServiceApplication;
import com.restaurantServices.dao.RestaurantRepo;
import com.restaurantServices.model.Driver;
import com.restaurantServices.model.Restaurant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest(classes = RestaurantServiceApplication.class)
class RestaurantServiceApplicationTests {

    @Autowired
    private RestaurantRepo restaurantRepo;
    @Test
    void populateDB() {
        Driver driver1 = Driver.builder().name("Driver1").build();
        Driver driver2 = Driver.builder().name("Driver2").build();
        Driver driver3 = Driver.builder().name("Driver3").build();
        Driver driver4 = Driver.builder().name("Driver4").build();
        Driver driver5 = Driver.builder().name("Driver5").build();
        Driver driver6 = Driver.builder().name("Driver6").build();
        Restaurant vogliaDiPizza = Restaurant.builder()
                .name("Voglia di pizza").address("Via Roma")
                .city("Roma")
                .drivers(Set.of(driver1, driver2, driver3))
                .build();
        Restaurant pizzaAGoGo = Restaurant.builder()
                .name("Pizza a GoGo")
                .address("Via Milano")
                .city("Milano")
                .drivers(Set.of(driver4, driver5, driver6)).build();
        restaurantRepo.saveAll(List.of(vogliaDiPizza, pizzaAGoGo));


    }
}
