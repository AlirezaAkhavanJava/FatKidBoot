package com.arcade.FatKidBoot.event.Listener;

import com.arcade.FatKidBoot.event.UserEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener{

    @Async
    @EventListener(classes = {UserEvent.class})
    public void handleUserRegisterEvent(UserEvent userEvent) {
        // VERIFICATION TOKEN
        //SEND IT TO USER

        System.out.println("UserEventListener handleUserRegisterEvent");
        userEvent.setWelcomeEmail(true);
    }
}
