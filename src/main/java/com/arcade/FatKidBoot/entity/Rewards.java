package com.arcade.FatKidBoot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rewards {

    @Id
    private UUID reward_id;
    private String reward_name;
    private String reward_description;




    /*MANY USERS CAN GET MANY REWARDS*/
    @ManyToMany(mappedBy = "rewards" )  // "rewards" = field name in User class
    private Set<User> users = new HashSet<>();

}
