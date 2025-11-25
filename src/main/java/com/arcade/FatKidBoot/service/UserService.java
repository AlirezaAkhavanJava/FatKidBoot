package com.arcade.FatKidBoot.service;


import com.arcade.FatKidBoot.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveNewUser(User user);

    Optional<User> findById(Long id);


}
