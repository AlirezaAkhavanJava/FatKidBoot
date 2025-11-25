package com.arcade.FatKidBoot.repository;

import com.arcade.FatKidBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
