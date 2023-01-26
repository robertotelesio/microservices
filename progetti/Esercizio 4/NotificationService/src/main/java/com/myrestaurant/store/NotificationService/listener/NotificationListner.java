package com.myrestaurant.store.NotificationService.listener;

import com.myrestaurant.store.NotificationService.service.EmailService;
import com.myrestaurant.store.NotificationService.service.SMSService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationListner {

    private final EmailService emailService;

    private final SMSService smsService;

    @RabbitListener(queues = {"${app.rabbitmq.notify-pizzas-added-routingkey}"})
    public void onNotifyAddPizzaToRestaurant(String message) {
        log.info("into notify method.");
        emailService.sendMessage(message);
        smsService.sendMessage(message);
    }
}
