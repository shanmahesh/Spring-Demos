/**
 * 
 */
package com.demographics.domain;

import com.base.domain.AggregateId;
import com.demographics.application.api.dto.PersonDto;

/**
 * @author Mahesh S
 *
 */
public class PersonFactory {

	public Person createPerson(PersonDto personDto){
		//TODO validate
		
		AggregateId aggregateId = AggregateId.generate();
		//publisher.publish(new ClientPaidEvent(aggregateId, clientData, amount));
		return new Person(aggregateId);
	}
	
	
}
