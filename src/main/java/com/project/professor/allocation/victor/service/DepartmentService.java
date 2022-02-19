package com.project.professor.allocation.victor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.victor.entity.Department;
import com.project.professor.allocation.victor.repository.DepartamentRepository;

@Service
public class DepartmentService {
	
	private final DepartamentRepository departamentRepository;
	
	public DepartmentService(DepartamentRepository departamentRepository) {
		super();
		this.departamentRepository = departamentRepository;
	}
	
	public List<Department> findAll(String name) {
		if (name == null) {
            return departamentRepository.findAll();
        } else {
            return departamentRepository.findByNameContainingIgnoreCase(name);
        }
	}
	
	public Department findById(Long id) {
		return departamentRepository.findById(id).orElse(null);
	}
	
	public Department save(Department departament) {
		departament.setId(null);
		return departament;
	}
		
	public Department update(Department departament) {
		Long id = departament.getId();
		if (id != null && departamentRepository.existsById(id)) {
			return departament;
		} else {
			return null;
		}
	}
	
	public void deleteById(Long id) {
		if (departamentRepository.existsById(id)) {
			departamentRepository.deleteById(id);
		}
	}
	
	public void deleteAll() {
		departamentRepository.deleteAllInBatch();
	}

	

}
