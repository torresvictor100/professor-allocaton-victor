package com.project.professor.allocation.victor.service;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.victor.entity.Departament;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentServiceTest {
	
	@Autowired
	DepartmentService departmentService;
	
	@Test
	public void findAll() {

		List<Departament> department = departmentService.findAll();
		department.forEach(System.out::println);
	}
	
	@Test
	public void findById() {

		Long id = 1L;

		Departament departament = departmentService.findById(id);

		System.out.println(departament);
	}
	
	@Test
	public void save() throws ParseException {

		Departament departament = new Departament();
		departament.setId(null);
		departament.setName("test");
		

		departament = departmentService.save(departament);
		System.out.println(departament);
	}
	
	@Test
	public void update() throws ParseException {

		Departament departament = new Departament();
		departament.setId(1l);
		departament.setName("test");
		

		departament = departmentService.save(departament);
		System.out.println(departament);
	}
	
	@Test
	public void deleteById() {
		Long id = 1L;

		departmentService.deleteById(id);
	}
	
	@Test
	public void deleteAll() {
		departmentService.deleteAll();
	}


}
