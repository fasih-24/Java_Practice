package com.faiz.javaguide.springboot.repository;

import com.faiz.javaguide.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long>{
}
