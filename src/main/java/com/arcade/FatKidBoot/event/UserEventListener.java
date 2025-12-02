package com.arcade.FatKidBoot.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {

    @Async
    @EventListener(classes = {UserEvent.class})
    public void handleUserRegisterEvent(UserEvent userEvent) {
        System.out.println("UserEventListener handleUserRegisterEvent");
        userEvent.setWelcomeEmail(true);
    }
}
