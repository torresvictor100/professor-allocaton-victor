package com.project.professor.allocation.victor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.victor.entity.Departament;
import com.project.professor.allocation.victor.repository.DepartamentRepository;

@Service
public class DepartmentService {
	
	private final DepartamentRepository departamentRepository;
	
	public DepartmentService(DepartamentRepository departamentRepository) {
		super();
		this.departamentRepository = departamentRepository;
	}
	
	public List<Departament> findAll() {
		return departamentRepository.findAll();
	}
	
	public Departament findById(Long id) {
		return departamentRepository.findById(id).orElse(null);
	}
	
	public Departament save(Departament departament) {
		departament.setId(null);
		return departament;
	}
		
	public Departament update(Departament departament) {
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
