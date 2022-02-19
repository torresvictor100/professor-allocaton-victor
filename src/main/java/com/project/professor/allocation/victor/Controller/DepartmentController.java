package com.project.professor.allocation.victor.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.professor.allocation.victor.entity.Department;
import com.project.professor.allocation.victor.service.DepartmentService;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
	
	private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        super();
        this.departmentService = departmentService;
    }
    
    public ResponseEntity<List<Department>> findAll(String name) {
        List<Department> departments = departmentService.findAll(name);
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }
    
    public ResponseEntity<Department> findById(Long id) {
        Department department = departmentService.findById(id);
        if (department == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    public ResponseEntity<Department> save(Department department) {
        try {
            department = departmentService.save(department);
            return new ResponseEntity<>(department, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    public ResponseEntity<Department> update(Long id, Department department) {
        department.setId(id);
        try {
            department = departmentService.update(department);
            if (department == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(department, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    public ResponseEntity<Void> deleteById(Long id) {
        departmentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    public ResponseEntity<Void> deleteAll() {
        departmentService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
