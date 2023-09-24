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

    private String name;

    @OneToMany(mappedBy = "gym")
    private List<GymMachine> gymList=new ArrayList<>();

    private Long oneFee;

    private Long oneMonthFee;

    private Long threeMonthFee;

    private Long sixMonthFee;

    private Long yearFee;



    public Gym(){

    }

    public Gym(String name, Long oneFee,
               Long oneMonthFee, Long threeMonthFee, Long sixMonthFee, Long yearFee) {

        this.name = name;
        this.oneFee = oneFee;
        this.oneMonthFee = oneMonthFee;
        this.threeMonthFee = threeMonthFee;
        this.sixMonthFee = sixMonthFee;
        this.yearFee = yearFee;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addGymMachine(GymMachine gymMachine){
        this.gymList.add(gymMachine);
    }
    public void setOneFee(Long oneFee) {
        this.oneFee = oneFee;
    }

    public void setOneMonthFee(Long oneMonthFee) {
        this.oneMonthFee = oneMonthFee;
    }

    public void setThreeMonthFee(Long threeMonthFee) {
        this.threeMonthFee = threeMonthFee;
    }

    public void setSixMonthFee(Long sixMonthFee) {
        this.sixMonthFee = sixMonthFee;
    }

    public void setYearFee(Long yearFee) {
        this.yearFee = yearFee;
    }
}
