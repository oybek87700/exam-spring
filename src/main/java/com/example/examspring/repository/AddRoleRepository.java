package com.example.examspring.repository;

import com.example.examspring.entity.AddRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddRoleRepository extends JpaRepository<AddRole,Integer> {

}
