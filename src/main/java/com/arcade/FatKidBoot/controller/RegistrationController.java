package com.arcade.FatKidBoot.controller;

import com.arcade.FatKidBoot.entity.User;
import com.arcade.FatKidBoot.event.RegistrationEvent;
import com.arcade.FatKidBoot.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController()
public class RegistrationController {

    private final UserService service;
    private final ApplicationEventPublisher publisher;

    // ======================== REGISTER ==========================
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> saveNewUser(@RequestBody User user, final HttpServletRequest request) {
        User addedUser = service.saveNewUser(user);
        URI location = URI.create("/register/" + addedUser.getId());

        publisher.publishEvent(new RegistrationEvent(addedUser,
                applicationUrl(request)
        ));


        return ResponseEntity.created(location).body(addedUser);
    }

    private String applicationUrl(HttpServletRequest request) {
        return "https://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
