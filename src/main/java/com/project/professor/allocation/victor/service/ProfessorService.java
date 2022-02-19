package com.project.professor.allocation.victor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.victor.entity.Allocation;
import com.project.professor.allocation.victor.entity.Department;
import com.project.professor.allocation.victor.entity.Professor;
import com.project.professor.allocation.victor.repository.AllocationRepository;
import com.project.professor.allocation.victor.repository.ProfessorRepository;

@Service
public class ProfessorService {

	private final ProfessorRepository professorRepository;

	private final DepartmentService departmentService;

	private final AllocationRepository allocationRepository;

	public ProfessorService(ProfessorRepository professorRepository, DepartmentService departmentService,
			 AllocationRepository allocationRepository) {
		super();
		this.professorRepository = professorRepository;
		this.departmentService = departmentService;
		this.allocationRepository = allocationRepository;

	}

	public List<Professor> findAll(String name) {
		  if (name == null) {
	            return professorRepository.findAll();
	        } else {
	            return professorRepository.findByNameContainingIgnoreCase(name);
	        }
	}

	public List<Professor> findByDepartmentId(Long departmentId) {
		return professorRepository.findByDepartmentId(departmentId);
	}

	public Professor findById(Long id) {
		return professorRepository.findById(id).orElse(null);
	}

	public Professor save(Professor professor) {
		professor.setId(null);
		return saveInternal(professor);
	}

	public Professor update(Professor professor) {
		Long id = professor.getId();
		if (id != null && professorRepository.existsById(id)) {
			return saveInternal(professor);
		} else {
			return null;
		}
	}

	private Professor saveInternal(Professor professor) {
		professor = professorRepository.save(professor);

		Department department = departmentService.findById(professor.getDepartmentId());
		professor.setDepartment(department);

		List<Allocation> allocations = allocationRepository.findByProfessorId(professor.getId()); //isso não entendi
		professor.setAllocations(allocations);

		return professor;
	}

	// private Professor saveInternal(Professor professor) {
	// professor = professorRepository.save(professor);

	// Departament department =
	// departmentService.findById(professor.getDepartmentId());
	// professor.setDepartment(department);

	// return professor;
	// }

	public void deleteById(Long id) {
		if (professorRepository.existsById(id)) {
			professorRepository.deleteById(id);
		}
	}

	public void deleteAll() {
		professorRepository.deleteAllInBatch();
	}

}
