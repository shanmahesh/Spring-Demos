/**
 * 
 */
package com.demographics.infrastructure.repo;

import com.demographics.domain.Person;
import com.demographics.domain.PersonRepository;
import com.domain.base.GenericJpaRepository;

/**
 * @author Mahesh S
 *
 */
public class jpaPersonRepository extends GenericJpaRepository<Person> implements PersonRepository {

}
