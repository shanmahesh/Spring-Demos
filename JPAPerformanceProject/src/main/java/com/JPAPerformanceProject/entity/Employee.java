package com.JPAPerformanceProject.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name="Employee")
@FetchProfile(name = "Employee_Projects", fetchOverrides = { 
		@FetchProfile.FetchOverride(entity = Employee.class, association = "projects", mode = FetchMode.JOIN), 
		@FetchProfile.FetchOverride(entity = Projects.class, association = "sprints", mode = FetchMode.JOIN)
})
@Table(name="Employee")
public class Employee {

	@Id @GeneratedValue(strategy=GenerationType.AUTO) long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="delete_in")
	private int delete_in;
	
	@OneToMany(mappedBy="employee",fetch=FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.EXTRA)
	//@BatchSize(size=100)
	private List<Projects> projects;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDelete_in() {
		return delete_in;
	}

	public void setDelete_in(int delete_in) {
		this.delete_in = delete_in;
	}

	public List<Projects> getProjects() {
		return projects;
	}

	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}
	
	
	
}
