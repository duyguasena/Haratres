package com.example.Haratres.repository;

import com.example.Haratres.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String userName);
    boolean existsByUserName(String userName);

}
