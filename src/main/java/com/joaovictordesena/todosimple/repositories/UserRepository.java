package com.joaovictordesena.todosimple.repositories;

import org.springframework.stereotype.Repository;

import com.joaovictordesena.todosimple.models.User;

import org.springframework.data.jpa.repository.JpaRepository;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    
} 