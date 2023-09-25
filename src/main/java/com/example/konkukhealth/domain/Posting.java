package com.example.konkukhealth.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
public class Posting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posting_id")
    private Long id;

    private String content;

    private String url;

    //회원엔티티생기면 추가
    //private Member member;

    //like

    //commit

    private LocalDateTime localDateTime;

    @OneToMany
    public List<Routine>routineList;

}
