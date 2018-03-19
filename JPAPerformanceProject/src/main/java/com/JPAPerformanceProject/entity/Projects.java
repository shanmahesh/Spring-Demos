package com.JPAPerformanceProject.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="Projects")
public class Projects {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="project_name")
	private String project_name;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Employee employee;


	@OneToMany(mappedBy="projects", fetch=FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.EXTRA)
	@Fetch(FetchMode.SUBSELECT)
	private Set<Sprints> sprints;
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getProject_name() {
		return project_name;
	}


	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Set<Sprints> getSprints() {
		return sprints;
	}


	public void setSprints(Set<Sprints> sprints) {
		this.sprints = sprints;
	}
	
	
	
	
}
