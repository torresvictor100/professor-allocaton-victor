package com.project.professor.allocation.victor.entity;


import java.time.DayOfWeek;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "professor_allocation")
public class Allocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Enumerated(EnumType.STRING) ele salva o texto correspondente ao valor do Enum. 
	//Se aguém inserir um valor direto no banco isso poderia ser um problema..
	@Enumerated(EnumType.STRING)
    @Column(name = "day", nullable = false)
	private DayOfWeek day;
	
	//não entendi muito bem perguntar
	@Temporal(TemporalType.TIME)
	@Column(name = "start", nullable = false)
	private Date start;
	
	@Temporal(TemporalType.TIME)
    @Column(name = "end", nullable = false)
	private Date end;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(optional = false)
	@JoinColumn(name = "course_id", nullable = false, insertable = false, updatable = false)
	private Course course;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(optional = false)
	@JoinColumn(name = "allocation_id", nullable = false, insertable = false, updatable = false)
	private Professor professor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DayOfWeek getDay() {
		return day;
	}
	public void setDay(DayOfWeek day) {
		this.day = day;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourseId(Course course) {
		this.course = course;
	}
	public Professor  getProfessor() {
		return professor;
	}
	public void setProfessorId(Professor professor) {
		this.professor = professor;
	}
	@Override
	public String toString() {
		return "Allocation [id=" + id + ", day=" + day + ", start=" + start + ", end=" + end + ", course=" + course
				+ ", professorId=" + professor + "]";
	}
	public Allocation(DayOfWeek day, Date start, Date end, Course course, Professor professor) {
		this.day = day;
		this.start = start;
		this.end = end;
		this.course = course;
		this.professor = professor;
	}
	
	

}
