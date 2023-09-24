package com.example.konkukhealth.repository;

import com.example.konkukhealth.domain.Gym;
import com.example.konkukhealth.domain.GymMachine;
import com.example.konkukhealth.domain.Machine;
import com.example.konkukhealth.repository.gym.GymSimpleDto;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GymRepository {
    public final EntityManager em;

    public void save(Gym gym){
        em.persist(gym);
    }

    public Gym findOneById(Long id){
        return em.find(Gym.class,id);
    }

    public Gym findOneByName(String name){
        Gym singleResult = em.createQuery("select i from Gym i"
                + " where i.name=name", Gym.class).getSingleResult();
        return singleResult;
    }
    public List<Gym>findAll(){
        return em.createQuery("select i from Gym i", Gym.class)
                .getResultList();

    }
    public List<GymSimpleDto>findAllWithSimpleDto(){
        return em.createQuery("select new com.example.konkukhealth.repository.gym.GymSimpleDto(g.id,g.name,g.oneFee,g.oneMonthFee,g.threeMonthFee,g.sixMonthFee,g.yearFee) "+
                "from Gym g ", GymSimpleDto.class).getResultList();
    }





}
