package com.example.konkukhealth.repository;

import com.example.konkukhealth.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public EntityManager em;

    @Autowired
    public PlatformTransactionManager transactionManager;

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
    public void saveUserTest(){
        User user = new User();
        user.setId("나야나");
        user.setPassword("123123");
        userRepository.save(user);

        User savedUser = userRepository.findById("나야나").orElse(null);
        assertNotNull(savedUser);
        assertEquals("123123", savedUser.getPassword());
    }

    @Test
    public void findById() {
        User user1 = new User();
        user1.setId("spring1");
        user1.setPassword("123123");
        userRepository.save(user1);

        User user2 = new User();
        user2.setId("spring2");
        user2.setPassword("123123");
        userRepository.save(user2);

        User result = userRepository.findById("spring1").get();

        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(user1);
    }
    /*
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        org.assertj.core.api.Assertions.assertThat(result.size()).isEqualTo(2);
    }
    */
}
