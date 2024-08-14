package com.company.service;


import com.company.dto.UserEntityCriteria;
import com.company.entity.UserEntity;
import com.company.repository.second.CustomRepository;
import com.company.repository.first.FirstUserRepository;
import com.company.repository.second.SecondUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final FirstUserRepository firstUserRepository;
    private final SecondUserRepository secondUserRepository;
    private final CustomRepository customRepository;


    public UserEntity save(UserEntity userEntity) {
        return firstUserRepository.save(userEntity);
    }

    public UserEntity findById(Long id) {
        return secondUserRepository.findById(id).get();
    }

    public List<UserEntity> allUser(UserEntityCriteria criteria) {
        return customRepository.userEntityList(criteria);
    }
}
