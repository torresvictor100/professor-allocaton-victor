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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Table(name = "allocation")
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
    @JsonFormat(pattern = "HH:mmZ")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @Temporal(TemporalType.TIME)
    @Column(name = "start", nullable = false)
	private Date start;
	

    @JsonFormat(pattern = "HH:mmZ")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @Temporal(TemporalType.TIME)
    @Column(name = "end", nullable = false)
	private Date end;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "professor_id", nullable = false)
    private Long professorId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "course_id", nullable = false)
    private Long courseId;
	
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@ManyToOne(optional = false)
	@JoinColumn(name = "course_id", nullable = false, insertable = false, updatable = false)
	private Course course;
	
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@ManyToOne(optional = false)
	@JoinColumn(name = "professor_id", nullable = false, insertable = false, updatable = false)
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
	public void setCourse(Course course) {
		this.course = course;
	}
	public Professor  getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Long getProfessorId() {
		return professorId;
	}
	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	
	
	
	

}
