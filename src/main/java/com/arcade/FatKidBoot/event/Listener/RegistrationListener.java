package com.arcade.FatKidBoot.event.Listener;

import com.arcade.FatKidBoot.entity.User;
import com.arcade.FatKidBoot.event.RegistrationEvent;
import com.arcade.FatKidBoot.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class RegistrationListener
        implements ApplicationListener<RegistrationEvent> {

    private final UserService userService;

    @Override
    public void onApplicationEvent(RegistrationEvent event) {
        User user = (User) event.getSource();
        String TOKEN = UUID.randomUUID().toString();
        userService.saveUsersToken(TOKEN, user);
        String url = event.getUrl() + "verifyRegistration?token=" + TOKEN;
        log.info("Verify registration url: {}", url);
    }
}
