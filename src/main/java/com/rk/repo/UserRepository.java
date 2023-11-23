package com.rk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
