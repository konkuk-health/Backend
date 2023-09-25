package com.example.konkukhealth.repository;

import com.example.konkukhealth.domain.Gym;
import com.example.konkukhealth.domain.GymMachine;
import com.example.konkukhealth.domain.Machine;
import com.example.konkukhealth.repository.gym.MachineSimpleDto;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface MachineRepositoryImpl {
    public final EntityManager em=null;

    public abstract void save(Machine machine);
    public abstract Machine findOneById(Long id);

    public abstract List<MachineSimpleDto> findAllBySimpleDto(Gym gym);
    public abstract void addMachine(Gym gym,Machine machine);
}
