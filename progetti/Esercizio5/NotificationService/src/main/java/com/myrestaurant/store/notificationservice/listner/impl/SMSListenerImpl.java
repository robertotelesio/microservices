package com.myrestaurant.store.notificationservice.listner.impl;

import com.myrestaurant.store.notificationservice.listner.NotificationListner;
import com.myrestaurant.store.notificationservice.service.SMSService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
@Profile("sms")
public class SMSListenerImpl implements NotificationListner {

    private final SMSService smsService;

    @Override
    public void onNotifyPizzasToRestaurantAdded(String message) {
        log.info("into sms - Into onAddPizzasToRestaurant method.");
        smsService.sendMessagge(message);

    }
}
