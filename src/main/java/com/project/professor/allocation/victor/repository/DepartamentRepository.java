package com.project.professor.allocation.victor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.victor.entity.Department;

@Repository
public interface DepartamentRepository extends JpaRepository<Department, Long>{

	List<Department> findByNameContainingIgnoreCase(String name);

}
