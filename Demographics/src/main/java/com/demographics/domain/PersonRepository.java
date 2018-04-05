/**
 * 
 */
package com.demographics.domain;

import com.domain.base.AggregateId;

/**
 * @author Mahesh S
 *
 */
public interface PersonRepository {

	public Person load(AggregateId paymentId);
	
	public void save(Person payment);
}
