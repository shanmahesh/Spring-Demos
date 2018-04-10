/**
 * 
 */
package com.demographics.infrastructure.repo;


import com.demographics.domain.Person;
import com.demographics.domain.PersonRepository;

import org.springframework.stereotype.Component;

import com.base.domain.GenericJpaRepository;

/**
 * @author Mahesh S
 *
 */
@Component
public class jpaPersonRepository extends GenericJpaRepository<Person> implements PersonRepository {

}
