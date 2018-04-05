/**
 * 
 */
package com.demographics.domain;

import com.domain.base.AggregateId;

/**
 * @author Mahesh S
 *
 */
public class PersonFactory {

	public Person createPerson(){
		//TODO validate
		
		AggregateId aggregateId = AggregateId.generate();
		//publisher.publish(new ClientPaidEvent(aggregateId, clientData, amount));
		return new Person(aggregateId);
	}
	
	
}
