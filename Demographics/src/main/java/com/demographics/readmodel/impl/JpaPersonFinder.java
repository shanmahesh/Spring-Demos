/**
 * 
 */
package com.demographics.readmodel.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.base.domain.AggregateId;
import com.demographics.application.api.dto.PersonDto;
import com.demographics.domain.Person;
import com.demographics.readmodel.PersonFinder;



/**
 * @author Mahesh S
 *
 *
 */
@Component
public class JpaPersonFinder implements PersonFinder {

	  @PersistenceContext
	    private EntityManager entityManager;

	    @SuppressWarnings("unchecked")
		@Override
	    public PersonDto getPersonDetails(AggregateId prsnId) throws Exception{
	        String jpql = "from Person p where p.aggregate_id = :prsnId";
	        Query query = entityManager.createQuery(jpql);
	        query.setParameter(0, prsnId);
	        query.setMaxResults(1);
	        Person p = (Person) query.getSingleResult();
	        PersonDto dto = new PersonDto();
	        BeanUtils.copyProperties(p, dto);
	        dto.setPrsnId(p.getAggregateId().getId());
	        
	        return dto;
	    }
	
	    
	    @Override
	    public List<PersonDto> getPersons() throws Exception{
	        String jpql = "from Person p";
	        Query query = entityManager.createQuery(jpql);
	      
	        List<Person> p = (List<Person>) query.getResultList();
	        
	        
	        List<PersonDto> prsnDtos = p.stream().map(prsn-> 
	        	{  
	        		PersonDto dto = new PersonDto();
	        		BeanUtils.copyProperties(prsn, dto);
	        		dto.setPrsnId(prsn.getAggregateId().getId());
	        		return dto;
	        
	        	}
	        ).collect(Collectors.toList());
	        
	        return prsnDtos;
	    }
	
}
