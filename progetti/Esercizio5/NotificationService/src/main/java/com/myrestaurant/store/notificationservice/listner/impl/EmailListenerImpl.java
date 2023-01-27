package com.myrestaurant.store.notificationservice.listner.impl;

import com.myrestaurant.store.notificationservice.listner.NotificationListner;
import com.myrestaurant.store.notificationservice.service.EmailService;
import com.myrestaurant.store.notificationservice.service.SMSService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
@Profile("email")
public class EmailListenerImpl implements NotificationListner {

    private final EmailService emailService;

    private final SMSService smsService;



    @Override
    @RabbitListener(queues = {"${app.rabbitmq.notify-pizzas-added-routingkey}"})
    public void onNotifyPizzasToRestaurantAdded(String message) {
        log.info("into email - Into onAddPizzasToRestaurant method.");
        emailService.sendMessagge(message);
    }

}

