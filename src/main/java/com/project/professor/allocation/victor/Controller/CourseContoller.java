package com.project.professor.allocation.victor.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.professor.allocation.victor.entity.Course;
import com.project.professor.allocation.victor.service.CourseService;

public class CourseContoller {
	
	private final CourseService courseService;
	
	public CourseContoller(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	
	public ResponseEntity<List<Course>> findAll(String name) {
        List<Course> course = courseService.findAll(name);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
	
	
	public ResponseEntity<Course> findById(Long id) {
		Course course = courseService.findById(id);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
	
	 public ResponseEntity<Course> save(Course course) {
	        try {
	        	course = courseService.save(course);
	            return new ResponseEntity<>(course, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }
	 
	 
	 public ResponseEntity<Course> update(Long id, Course course) {
		 course.setId(id);
	        try {
	        	course = courseService.update(course);
	            if (course == null) {
	                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	            } else {
	                return new ResponseEntity<>(course, HttpStatus.OK);
	            }
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }
	 
	 
	 public ResponseEntity<Void> deleteById(Long id) {
		 courseService.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    public ResponseEntity<Void> deleteAll() {
	    	courseService.deleteAll();
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	

}
