package com.demographics.domain;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.beans.BeanUtils;

import com.base.domain.AggregateId;
import com.base.domain.BaseAggregateRoot;
import com.demographics.application.api.dto.PersonDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




/**
 * 
 * @author Mahesh S
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
	
	
	public Person(PersonDto prsnDto) {
		BeanUtils.copyProperties(prsnDto, this);
		this.aggregateId = AggregateId.generate();
		this.validate();
		
	}
	
	public void validate() {
		
	} 
	
	
	public void updatePersonDetails(PersonDto personDto) {
		BeanUtils.copyProperties(personDto, this);
		this.validate();
	}
	
	public boolean canDelete() {
		//Validate
		return true;
	}
	
}
