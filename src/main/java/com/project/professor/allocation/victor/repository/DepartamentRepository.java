package com.project.professor.allocation.victor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.victor.entity.Departament;

@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Long>{

}
