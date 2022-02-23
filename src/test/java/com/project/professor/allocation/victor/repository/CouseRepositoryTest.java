package com.project.professor.allocation.victor.repository;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.victor.entity.Course;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class CouseRepositoryTest {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Test
	public void findAll() {
		
		List<Course> courses = courseRepository.findAll();
		courses.forEach(System.out::println);
	}
	
	@Test
    public void findById() {
        Long id = 1L;
        Course course = courseRepository.findById(id).orElse(null);

        System.out.println(course);
    }
	
	
	@Test
	public void save_create() throws ParseException {
		Course course = new Course();
		course.setId(null);
		course.setName("teste");	
		
		courseRepository.save(course);
		
		System.out.println(course);
		
	}
	
	@Test
	public void save_update() throws ParseException {
		Course course = new Course();
		course.setId(1L);
		course.setName("teste");	
		
		courseRepository.save(course);
		
		System.out.println(course);
		
	}
	
	@Test
	public void deleteById() {
	
		Long id = 1L;

		courseRepository.deleteById(id);
	}
	
	@Test
	public void deleteAll() {
	
		courseRepository.deleteAllInBatch();
	}
	

}
