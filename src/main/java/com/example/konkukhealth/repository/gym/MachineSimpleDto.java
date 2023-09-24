package com.example.konkukhealth.repository.gym;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MachineSimpleDto {

    private Long id;
    private String company;
    private String name;
    private int count;

    public MachineSimpleDto(Long id, String company, String name, int count) {
        this.id = id;
        this.company = company;
        this.name = name;
        this.count = count;
    }
}
