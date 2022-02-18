package com.project.professor.allocation.victor.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "professor")
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "cpf", unique = true, nullable = false, length = 14)
	private String cpf;
	
	
	
	//id departamento?? não era apra ser um departament?? isso fala que vai remover em cascata todos os professores quando o departamento for removivo
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(optional = false)
	@JoinColumn(name = "department_id", nullable = false, insertable = false, updatable = false)
	private Departament department;
	
	@OneToMany(mappedBy = "professor")
	private List<Allocation> allocation;
	
	
	public List<Allocation> getAllocation() {
		return allocation;
	}

	public void setAllocation(List<Allocation> allocation) {
		this.allocation = allocation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Departament getDepartment() {
		return department;
	}

	public void setDepartment(Departament department) {
		this.department = department;
	}

	

	public Professor(String name, String cpf, Departament department) {
		this.name = name;
		this.cpf = cpf;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + ", cpf=" + cpf + ", department=" + department + "]";
	}

	
	
	
	
	

}
