package com.example.konkukhealth.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gym_id")
    private Long id;

    @OneToMany(mappedBy = "gym")
    private List<GymMachine> gymList=new ArrayList<>();

    private Long oneFee;

    private Long oneMonthFee;

    private Long threeMonthFee;

    private Long sixMonthFee;

    private Long yearFee;

}
