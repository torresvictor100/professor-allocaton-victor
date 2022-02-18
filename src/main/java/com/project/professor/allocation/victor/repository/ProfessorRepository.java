package com.project.professor.allocation.victor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.victor.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
	
	
	List<Professor> findByDepartmentId(Long departmentId);
	
	List<Professor> findByNameContainingIgnoreCase(String name);


}
