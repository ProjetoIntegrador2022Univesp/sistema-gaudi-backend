package com.gaudisystems.sistemagaudi.modules.courses.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gaudisystems.sistemagaudi.modules.contract.models.Contract;
import com.gaudisystems.sistemagaudi.modules.coursemodules.models.CourseModule;

import lombok.Data;

@Entity
@Data
@Table(name = "courses")
public class Course {
    
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CourseModule> courseModules;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contract> contract;



	public Course() {
	}

	public Course(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Course(String name, String description, List<CourseModule> courseModules) {
		this.name = name;
		this.description = description;
		this.courseModules = courseModules;
	}

	

}