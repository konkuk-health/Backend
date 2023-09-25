package com.example.konkukhealth.service;

import com.example.konkukhealth.domain.Gym;
import com.example.konkukhealth.domain.Machine;
import com.example.konkukhealth.repository.MachineRepository;
import com.example.konkukhealth.repository.gym.MachineSimpleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MachineService {

    private final MachineRepository machineRepository;

    public void addMachine(Gym gym, Machine machine){
        machineRepository.addMachine(gym,machine);
    }

    public List<MachineSimpleDto> findAllBySimpleDto(Gym gym){
        return machineRepository.findAllBySimpleDto(gym);
    }


}
