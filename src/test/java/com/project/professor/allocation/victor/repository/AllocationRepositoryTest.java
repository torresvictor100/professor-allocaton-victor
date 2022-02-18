	package com.project.professor.allocation.victor.repository;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.victor.entity.Allocation;
import com.project.professor.allocation.victor.entity.Course;
import com.project.professor.allocation.victor.entity.Professor;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationRepositoryTest {

	@Autowired
	AllocationRepository allocationRepository;

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

	@Test
	public void findAll() {
		
		List<Allocation> allocations = allocationRepository.findAll();

		allocations.forEach(System.out::println);
	}

	@Test
	public void findByProfessorId() {
	
		Long professorId = 1L;
		
		List<Allocation> allocations = allocationRepository.findByProfessorId(professorId);

		allocations.forEach(System.out::println);
	}

	@Test
	public void findByCourseId() {

		Long courseId = 1L;

		List<Allocation> allocations = allocationRepository.findByCourseId(courseId);

		allocations.forEach(System.out::println);
	}

	@Test
	public void save_create() throws ParseException {


		Professor professor = new Professor();
		Course course = new Course();

		Allocation allocation = new Allocation();
		allocation.setId(null);
		allocation.setDay(DayOfWeek.SUNDAY);
		allocation.setStart(sdf.parse("17:00-0300"));
		allocation.setEnd(sdf.parse("18:00-0300"));
		allocation.setProfessor(professor);
		allocation.setCourse(course);

		allocation = allocationRepository.save(allocation);

		System.out.println(allocation);
	}

	@Test
	public void save_update() throws ParseException {
		Professor professor = new Professor();

		Course couse = new Course();
		// Arrange
		Allocation allocation = new Allocation();
		allocation.setId(1L);
		allocation.setDay(DayOfWeek.MONDAY);
		allocation.setStart(sdf.parse("19:00-0300"));
		allocation.setEnd(sdf.parse("20:00-0300"));
		allocation.setProfessor(professor);
		allocation.setCourse(couse);

		
		allocation = allocationRepository.save(allocation);

		
		System.out.println(allocation);
	}

	@Test
	public void deleteById() {
	
		Long id = 1L;

		allocationRepository.deleteById(id);
	}

	@Test
	public void deleteAll() {
	
		allocationRepository.deleteAllInBatch();
	}

}
