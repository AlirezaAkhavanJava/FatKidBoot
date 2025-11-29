package com.arcade.FatKidBoot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rewards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reward_id;
    private String reward_name;
    private String reward_description;




    /*MANY USERS CAN GET MANY REWARDS*/
    @ManyToMany(mappedBy = "rewards" )  // "rewards" = field name in User class
    private Set<User> users = new HashSet<>();

}
