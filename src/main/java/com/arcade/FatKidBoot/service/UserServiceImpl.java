package com.arcade.FatKidBoot.service;

import com.arcade.FatKidBoot.entity.User;
import com.arcade.FatKidBoot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Transactional
    @Override
    public User saveNewUser(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

}
