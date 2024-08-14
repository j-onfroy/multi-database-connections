package com.company.repository.second;

import com.company.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondUserRepository extends JpaRepository<UserEntity, Long> {

}
