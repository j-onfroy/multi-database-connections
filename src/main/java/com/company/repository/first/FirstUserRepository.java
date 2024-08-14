package com.company.repository.first;

import com.company.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstUserRepository extends JpaRepository<UserEntity,Long> {

}
