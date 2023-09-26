package com.example.konkukhealth.service;

import com.example.konkukhealth.domain.User;
import com.example.konkukhealth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String join(User user) {
        //같은 id 있는 중복 회원X
        validateDuplicateMember(user);


        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateMember(User user) {
        userRepository.findById(user.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
