/**
 * 
 */
package com.demographics.readmodel;

import java.util.List;

import com.base.domain.AggregateId;
import com.demographics.application.api.dto.PersonDto;

/**
 * @author Mahesh S
 *
 */
public interface PersonFinder {
	
	List<PersonDto> getPersonList();
	
	PersonDto getPersonDetails(AggregateId personId); 
	
}
