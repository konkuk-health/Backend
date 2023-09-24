package com.example.konkukhealth.repository;


import com.example.konkukhealth.domain.Gym;
import com.example.konkukhealth.domain.GymMachine;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GymMachineRepository {

    private EntityManager em;

    public void save(GymMachine gymMachine){
        em.persist(gymMachine);
    }
    public GymMachine findOneById(Long id){
        return em.find(GymMachine.class,id);
    }


}
