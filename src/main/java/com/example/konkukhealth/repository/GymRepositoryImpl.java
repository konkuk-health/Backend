package com.example.konkukhealth.repository;

import com.example.konkukhealth.domain.Gym;
import com.example.konkukhealth.repository.gym.GymSimpleDto;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface GymRepositoryImpl {
    public final EntityManager em=null;

    public abstract void save(Gym gym);

    public abstract Gym findOneById(Long id);

    public abstract Gym findOneByName(String name);
    public abstract List<Gym> findAll();
    public abstract List<GymSimpleDto>findAllWithSimpleDto();
}
