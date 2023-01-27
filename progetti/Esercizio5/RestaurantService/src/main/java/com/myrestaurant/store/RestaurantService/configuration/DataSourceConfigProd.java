package com.myrestaurant.store.RestaurantService.configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class DataSourceConfigProd {

    public DataSourceConfigProd(){
        System.out.println("into DataSourceConfigProd class");
    }
}
