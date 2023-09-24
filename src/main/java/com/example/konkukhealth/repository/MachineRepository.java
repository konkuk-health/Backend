package com.example.konkukhealth.repository;

import com.example.konkukhealth.domain.Gym;
import com.example.konkukhealth.domain.GymMachine;
import com.example.konkukhealth.domain.Machine;
import com.example.konkukhealth.repository.gym.GymSimpleDto;
import com.example.konkukhealth.repository.gym.MachineSimpleDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MachineRepository {

    private final EntityManager em;

    public void save(Machine machine){
        em.persist(machine);
    }
    public Machine findOneById(Long id){
        return em.find(Machine.class,id);
    }

    public List<MachineSimpleDto> findAllBySimpleDto(Gym gym){
        return em.createQuery("select new com.example.konkukhealth.repository.gym.MachineSimpleDto(m.id,m.company,m.name,m.count) "+
                "from Machine m "+
                "left join m.gymList gymlist "+
                "left join gymlist.machine machine "+
                "where machine.id= :gymId", MachineSimpleDto.class)
                .setParameter("gymId",gym.getId()).getResultList();

    }
    public void addMachine(Gym gym,Machine machine){
        GymMachine gymMachine=new GymMachine(gym,machine);
        em.persist(gymMachine);
        gym.addGymMachine(gymMachine);
        machine.addGymMachine(gymMachine);
    }
}
