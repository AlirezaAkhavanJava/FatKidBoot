package com.arcade.FatKidBoot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class EmploymentCard {

    //RELATIONS
    @OneToOne(mappedBy = "employmentCard")
    private User user;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employment_Id;
    private String department;
    private String desk_number;
    private String profession;




}
