package com.JPAPerformanceProject.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Sprints")
public class Sprints {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="sprint_no")
	private String sprint_no;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Projects projects;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSprint_no() {
		return sprint_no;
	}

	public void setSprint_no(String sprint_no) {
		this.sprint_no = sprint_no;
	}

	public Projects getProjects() {
		return projects;
	}

	public void setProjects(Projects projects) {
		this.projects = projects;
	}
	
	
	
	
}
