package com.arcade.FatKidBoot.service;

import com.arcade.FatKidBoot.entity.User;
import com.arcade.FatKidBoot.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    // Full replace – copy all fields (except id)
                    existingUser.setUsername(updatedUser.getUsername());
                    existingUser.setEmail(updatedUser.getEmail());
                    existingUser.setPassword(updatedUser.getPassword()); // NO SECURITY YET
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    @Transactional
    @Override
    public User partialUpdateUser(Long id, User patchUser) {
        return userRepository.findById(id).map(existingUser -> {
            if (Objects.nonNull(patchUser.getUsername()) && !patchUser.getUsername().isBlank()) {
                existingUser.setUsername(patchUser.getUsername());
            }
            if (Objects.nonNull(patchUser.getEmail()) && !patchUser.getEmail().isBlank()) {
                existingUser.setEmail(patchUser.getEmail());
            }
            if (Objects.nonNull(patchUser.getPassword()) && !patchUser.getPassword().isBlank()) {
                existingUser.setPassword(patchUser.getPassword()); // NO SECURITY YET
            }
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }


    @Transactional
    @Override
    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

}
