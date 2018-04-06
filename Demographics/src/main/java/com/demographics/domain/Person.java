package com.demographics.domain;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.base.domain.AggregateId;
import com.base.domain.BaseAggregateRoot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;




/**
 * 
 * @author Mahesh S
 *
 */
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Person extends BaseAggregateRoot{

	public String firstName;
	public String lastName;
	public String midName;
	public String SSN;
	public Date dob;
	

	@OneToMany
	@JoinColumn(name = "prsn_id")
	private Set<Address> address = new LinkedHashSet<>();
	
	public Person(AggregateId aggregateId) {
		this.aggregateId = aggregateId;
	}
}
