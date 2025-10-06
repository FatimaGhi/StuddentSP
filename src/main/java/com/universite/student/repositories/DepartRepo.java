package com.universite.student.repositories;

import com.universite.student.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartRepo extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String name);
}
