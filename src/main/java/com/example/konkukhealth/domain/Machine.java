package com.example.konkukhealth.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Machine {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "machine_id")
    private Long id;

    @OneToMany(mappedBy = "machine")
    private List<GymMachine> gymList=new ArrayList<>();

    private String company;
    private String name;
    private int count;


}
