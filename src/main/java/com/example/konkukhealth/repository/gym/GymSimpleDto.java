package com.example.konkukhealth.repository.gym;

import lombok.Data;

@Data
public class GymSimpleDto {
    private Long id;

    private String name;
    private Long oneFee;

    private Long oneMonthFee;

    private Long threeMonthFee;

    private Long sixMonthFee;

    private Long yearFee;

    public GymSimpleDto(Long id,String name, Long oneFee, Long oneMonthFee,
                        Long threeMonthFee, Long sixMonthFee, Long yearFee) {
        this.id=id;
        this.name = name;
        this.oneFee = oneFee;
        this.oneMonthFee = oneMonthFee;
        this.threeMonthFee = threeMonthFee;
        this.sixMonthFee = sixMonthFee;
        this.yearFee = yearFee;
    }
}
