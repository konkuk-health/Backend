package com.example.konkukhealth.repository;

import com.example.konkukhealth.domain.GymMachine;
import jakarta.persistence.EntityManager;

public interface GymMachineRepositoryImpl {

    public final EntityManager em = null;

    public abstract void save(GymMachine gymMachine);
    public abstract GymMachine findOneById(Long id);
}
