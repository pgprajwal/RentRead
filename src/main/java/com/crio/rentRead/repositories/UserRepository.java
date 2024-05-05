package com.crio.rentRead.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.rentRead.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    
}
