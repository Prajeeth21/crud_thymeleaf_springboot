package com.prajeeth.crud_thymeleaf_springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prajeeth.crud_thymeleaf_springboot.model.User;

@Repository
public interface UsernameRepository extends JpaRepository<User, Integer>{
}
