package com.project.professor.allocation.victor.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.project.professor.allocation.victor.entity.Professor;
import com.project.professor.allocation.victor.service.ProfessorService;

@RequestMapping(path = "/professor")
public class ProfessorController {

	ProfessorService professorService;

	public ProfessorController(ProfessorService professorService) {
		super();
		this.professorService = professorService;

	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Professor>> findAll(@RequestParam(name = "name", required = false) String name) {
		List<Professor> professor = professorService.findAll(name);
		return new ResponseEntity<>(professor, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{professor_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Professor> findById(@PathVariable(name = "department_id") Long id) {
		Professor professor = professorService.findById(id);
		if (professor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(path = "department/{professor_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Professor> findByIdDepartment(@PathVariable(name = "professor_id") Long id) {
		List<Professor> professor = professorService.findByDepartmentId(id);
		if (professor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Professor> save(@RequestBody Professor professor) {
		try {
			professor = professorService.save(professor);
			return new ResponseEntity<>(professor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(path = "/{professor_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Professor> update(@PathVariable(name = "professor_id") Long id, @RequestBody Professor professor) {
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
	
	
	@DeleteMapping(path = "/{department_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteById(@PathVariable(name = "department_id") Long id) {
		professorService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteAll() {
		professorService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
