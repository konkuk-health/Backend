package com.example.konkukhealth.repository;

import com.example.konkukhealth.domain.Gym;
import com.example.konkukhealth.repository.gym.GymSimpleDto;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest

public class GymRepositoryTest {

    @Autowired
    public EntityManager em;

    @Autowired
    private PlatformTransactionManager transactionManager;
    @Autowired
    private GymRepository gymRepository;

    TransactionStatus status;
    @BeforeEach
    void beforeEach() {
        // 트랜잭션 시작
        status = transactionManager.getTransaction(new DefaultTransactionDefinition());
    }
    @AfterEach
    void afterEach() {
        // 트랜잭션 롤백
        transactionManager.rollback(status);
    }


    @Test
    @Transactional
    public void GYM저장_테스트() {
        String name="레미안 헬스장";
        Long oneFee=10000L;
        Gym gym=new Gym(name,oneFee,0L,0L,0L,0L);
        em.persist(gym);
        em.flush();
        Gym singleResult = em.createQuery("select i from Gym i"
                + " where i.name=name", Gym.class).getSingleResult();
        Assertions.assertThat(singleResult).isSameAs(gym);
    }
    @Test
    @Transactional
    public void GYM저장_테스트repository(){
        String name="레미안 헬스장";
        Long oneFee=10000L;
        Gym gym=new Gym(name,oneFee,0L,0L,0L,0L);
        gymRepository.save(gym);
        Gym singleResult = em.createQuery("select i from Gym i"
                + " where i.name=name", Gym.class).getSingleResult();
        Assertions.assertThat(singleResult).isSameAs(gym);

    }
    @Test
    @Transactional
    public void GYM전체_줄력_테스트(){
        String name="레미안 헬스장";
        Long oneFee=10000L;
        Gym gym=new Gym(name,oneFee,0L,0L,0L,0L);
        gymRepository.save(gym);
        GymSimpleDto dto=new GymSimpleDto(1L,name,oneFee,0L,0L,0L,0L);

        String name1="제이피트 헬스장";
        Long oneFee1=10000L;
        Gym gym1=new Gym(name1,oneFee,0L,0L,0L,0L);
        gymRepository.save(gym1);
        GymSimpleDto dto1=new GymSimpleDto(2L,name1,oneFee1,0L,0L,0L,0L);

        List<GymSimpleDto> allWithSimpleDto = gymRepository.findAllWithSimpleDto();
        for (GymSimpleDto gymSimpleDto : allWithSimpleDto) {
            System.out.println("gymSimpleDto.getName() = " + gymSimpleDto.getName());
            System.out.println("gymSimpleDto.getOneFee() = " + gymSimpleDto.getOneFee());
        }
    }


}
