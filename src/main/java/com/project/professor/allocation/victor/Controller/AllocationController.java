package com.project.professor.allocation.victor.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.professor.allocation.victor.entity.Allocation;
import com.project.professor.allocation.victor.service.AllocationService;

public class AllocationController {
	
	AllocationService allocationService;

	public AllocationController(AllocationService allocationService) {
		super();
		this.allocationService = allocationService;
	}
	
	public ResponseEntity<List<Allocation>> findAll() {
		List<Allocation> allocation = allocationService.findAll();
		return new ResponseEntity<>(allocation, HttpStatus.OK);
	}
	
	
	public ResponseEntity<Allocation> findById(Long id) {
		Allocation allocation = allocationService.findById(id);
		if (allocation == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<Allocation> findByIdCourse(Long id) {
		List<Allocation> allocation = allocationService.findByCourse(id);
		if (allocation == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<Allocation> findByIdProfessor(Long id) {
		List<Allocation> allocation = allocationService.findByProfessor(id);
		if (allocation == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<Allocation> save(Allocation allocation) {
		try {
			allocation = allocationService.save(allocation);
			return new ResponseEntity<>(allocation, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<Allocation> update(Long id, Allocation allocation) {
		allocation.setId(id); // isso não entendi bem
		try {
			allocation = allocationService.update(allocation);
			if (allocation == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(allocation, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	public ResponseEntity<Void> deleteById(Long id) {
		allocationService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Void> deleteAll() {
		allocationService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
