package com.prajeeth.crud_thymeleaf_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.prajeeth.crud_thymeleaf_springboot.model.student;

@Repository
public interface StudentRepository extends JpaRepository<student, Long>{
    @Query(value = "select * from students s where s.first_name like %:keyword% or s.last_name like %:keyword% or s.email like %:keyword%", nativeQuery=true)
    List<student> findByKeyword(@Param("keyword") String keyword);
    
}

