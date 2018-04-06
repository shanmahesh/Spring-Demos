/**
 * 
 */
package com.demographics.readmodel.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.base.domain.AggregateId;
import com.demographics.application.api.dto.PersonDto;
import com.demographics.domain.Person;
import com.demographics.readmodel.PersonFinder;



/**
 * @author Mahesh S
 *
 */
public class JpaPersonFinder implements PersonFinder {

	  @PersistenceContext
	    private EntityManager entityManager;

	    @SuppressWarnings("unchecked")
		@Override
	    public PersonDto getPersonDetails(AggregateId prsnId) {
	        String jpql = "from Person p";
	        Query query = entityManager.createQuery(jpql);
	        Person p = (Person) query.getSingleResult();
	        PersonDto dto = new PersonDto();
	        return dto;
	    }
	
	
}
