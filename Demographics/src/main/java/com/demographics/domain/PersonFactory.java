/**
 * 
 */
package com.demographics.domain;

import org.springframework.stereotype.Component;

import com.base.domain.AggregateId;
import com.demographics.application.api.dto.PersonDto;

/**
 * @author Mahesh S
 *
 */
@Component
public class PersonFactory {

	public Person createPerson(PersonDto personDto){
		//TODO validate
		
		//AggregateId aggregateId = AggregateId.generate();
		//publisher.publish(new ClientPaidEvent(aggregateId, clientData, amount));
		return new Person(personDto);
	}
	
	
}
