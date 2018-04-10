/**
 * 
 */
package com.demographics.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import com.base.domain.AggregateId;

/**
 * @author Mahesh S
 *
 */
public interface PersonRepository  {

	public Person load(AggregateId aggregateId);
	
	public void save(Person person);
}
