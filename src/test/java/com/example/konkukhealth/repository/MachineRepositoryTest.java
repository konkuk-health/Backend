package com.example.konkukhealth.repository;

import com.example.konkukhealth.domain.Gym;
import com.example.konkukhealth.domain.GymMachine;
import com.example.konkukhealth.domain.Machine;
import com.example.konkukhealth.repository.gym.MachineSimpleDto;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MachineRepositoryTest {
    @Autowired
    public EntityManager em;
    @Autowired
    public GymRepository gymRepository;
    @Autowired
    public MachineRepository machineRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;
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
    public void Machine_저장테스트(){
        String name="레미안 헬스장";
        Long oneFee=10000L;
        Gym gym=new Gym(name,oneFee,0L,0L,0L,0L);
        gymRepository.save(gym);

        Machine machine=new Machine("LIFE_FITNESS","렉",1);
        machineRepository.save(machine);
        machineRepository.addMachine(gym,machine);


        List<MachineSimpleDto> Dto = machineRepository.findAllBySimpleDto(gym);
        System.out.println("Dto = " + Dto.get(0).getName());
        Assertions.assertThat(Dto.get(0).getCompany()).isEqualTo("LIFE_FITNESS");

    }

}
