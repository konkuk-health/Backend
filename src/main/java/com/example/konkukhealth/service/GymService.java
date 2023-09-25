package com.example.konkukhealth.service;

import com.example.konkukhealth.domain.Gym;
import com.example.konkukhealth.domain.GymMachine;
import com.example.konkukhealth.repository.GymRepository;
import com.example.konkukhealth.repository.gym.GymSimpleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GymService {

    private final GymRepository gymRepository;

    @Transactional(readOnly = false)
    public void addGym(Gym gym){
        gymRepository.save(gym);
    }

    public List<GymSimpleDto>findAllSimpleDto(){
        return gymRepository.findAllWithSimpleDto();
    }


    @Transactional(readOnly = false)
    public void changeGym(Gym gym, String name){
        Gym gym1 = gymRepository.findOneByName(name);
        gym1.setName(gym.getName());
        gym1.setOneFee(gym.getOneFee());
        gym1.setOneMonthFee(gym.getOneMonthFee());
        gym1.setSixMonthFee(gym.getSixMonthFee());
        gym1.setYearFee(gym.getYearFee());
    }
    @Transactional(readOnly = false)
    public void changeGym(Gym gym, Long id){
        Gym gym1 = gymRepository.findOneById(id);
        gym1.setName(gym.getName());
        gym1.setOneFee(gym.getOneFee());
        gym1.setOneMonthFee(gym.getOneMonthFee());
        gym1.setSixMonthFee(gym.getSixMonthFee());
        gym1.setYearFee(gym.getYearFee());
    }
    public boolean sameName(String name){
        if(gymRepository.findOneByName(name)==null)
            return true;
        else
            return false;

    }
}
