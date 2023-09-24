package com.example.konkukhealth.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class GymMachine {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gymmachine_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="gym_id")
    private Gym gym;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="machine_id")
    private Machine machine;

    public GymMachine(){

    }
    public GymMachine(Gym gym, Machine machine) {
        this.gym = gym;
        this.machine = machine;
    }
}
