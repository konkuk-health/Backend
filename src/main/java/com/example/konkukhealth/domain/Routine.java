package com.example.konkukhealth.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routine_id")
    private Long id;

    public String machine;
    //자유로운 형식
    public int weight;
    public int sets;
    public int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="posting_id")
    public Posting posting;

}
