package com.project.professor.allocation.victor.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.professor.allocation.victor.entity.Professor;
import com.project.professor.allocation.victor.service.ProfessorService;

public class ProfessorController {

	ProfessorService professorService;

	public ProfessorController(ProfessorService professorService) {
		super();
		this.professorService = professorService;

	}

	public ResponseEntity<List<Professor>> findAll(String name) {
		List<Professor> professor = professorService.findAll(name);
		return new ResponseEntity<>(professor, HttpStatus.OK);
	}

	public ResponseEntity<Professor> findById(Long id) {
		Professor professor = professorService.findById(id);
		if (professor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Professor> findByIdDepartment(Long id) {
		List<Professor> professor = professorService.findByDepartmentId(id);
		if (professor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Professor> save(Professor professor) {
		try {
			professor = professorService.save(professor);
			return new ResponseEntity<>(professor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Professor> update(Long id, Professor professor) {
		professor.setId(id);
		try {
			professor = professorService.update(professor);
			if (professor == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(professor, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Void> deleteById(Long id) {
		professorService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Void> deleteAll() {
		professorService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
