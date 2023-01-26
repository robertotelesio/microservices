package com.myrestaurant.store.NotificationService.listener;

import com.myrestaurant.store.NotificationService.service.EmailService;
import com.myrestaurant.store.NotificationService.service.SMSService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationListner {

    private final EmailService emailService;

    private final SMSService smsService;

    @RabbitListener(queues = {"${app.rabbitmq.restaurant-service-routingkey}"})
    public void onAddPizzaToRestaurant(String message) {
        log.info("into onAddPizzaToRestaurant method.");
        emailService.sendMessage(message);
        smsService.sendMessage(message);
    }
}
