/**
 * 
 */
package com.demographics.domain;

import com.base.domain.AggregateId;

/**
 * @author Mahesh S
 *
 */
public interface PersonRepository {

	public Person load(AggregateId paymentId);
	
	public void save(Person payment);
}
