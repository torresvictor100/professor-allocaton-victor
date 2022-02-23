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

import com.project.professor.allocation.victor.entity.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class DepartamentRepositoryTest {
	
	@Autowired
	DepartamentRepository departamentoRepository;
	
	@Test
	public void findAll() {
		
		List<Department> departament = departamentoRepository.findAll();
		departament.forEach(System.out::println);
	}
	
	  @Test
	    public void findById() {
	      
	        Long id = 1L;

	        Department departament = departamentoRepository.findById(id).orElse(null);

	        System.out.println(departament);
	    }
	
	@Test
	public void save_create() throws ParseException {
		Department departament = new Department();
		departament.setId(null);
		departament.setName("teste");	
		
		departamentoRepository.save(departament);
		
		System.out.println(departament);
		
	}
	
	@Test
	public void save_update() throws ParseException {
		Department departament = new Department();
		departament.setId(1L);
		departament.setName("teste");	
		
		departamentoRepository.save(departament);
		
		System.out.println(departament);
		
	}
	
	@Test
	public void deleteById() {
	
		Long id = 1L;

		departamentoRepository.deleteById(id);
	}
	
	@Test
	public void deleteAll() {
	
		departamentoRepository.deleteAllInBatch();
	}

}
