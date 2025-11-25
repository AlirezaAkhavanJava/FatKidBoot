package com.arcade.FatKidBoot.controller;

import com.arcade.FatKidBoot.entity.User;
import com.arcade.FatKidBoot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;


    @PostMapping("/register")
    public ResponseEntity<User> saveNewUser(@RequestBody User user) {
        User addedUser = service.saveNewUser(user);
        URI location = URI.create("/register/" + addedUser.getId());
        return ResponseEntity.created(location).body(addedUser);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


}
