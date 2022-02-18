package com.project.professor.allocation.victor;

import java.util.ArrayList;
import java.util.List;

public class CyclicReferenceExample {
		
	public static class Department
	{
		Long id;
		List<Professor> professors;
		
		@Override
		public String toString() {
			return "Department [id=" + id + ", professors=" + professors + "]";
		}		
	}
	
	public static class Professor
	{
		Long id;
		Department department;

		@Override
		public String toString() {
			return "Professor [id=" + id + "]";
		}
	}
	
	public static void main(String[] args) {
		Department department = new Department();
		department.id = 1L;
		department.professors = new ArrayList<Professor>();
		
		Professor professor = new Professor();
		professor.id = 1L;
		professor.department = null;
		
		System.out.println(department);
		// Department [id=1, professors=[]]
		
		System.out.println(professor);
		// Professor [id=1, department=null]
		
		department.professors.add(professor);
		professor.department = department;
		
		System.out.println(professor);

	}
}
