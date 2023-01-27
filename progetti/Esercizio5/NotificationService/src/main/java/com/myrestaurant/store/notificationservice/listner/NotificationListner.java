package com.myrestaurant.store.notificationservice.listner;

import com.myrestaurant.store.notificationservice.service.EmailService;
import com.myrestaurant.store.notificationservice.service.SMSService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


public interface NotificationListner {

    void onNotifyPizzasToRestaurantAdded(String message);



    }
