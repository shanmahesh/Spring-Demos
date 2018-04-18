/**
 * 
 */
package com.contact.infrastructure;



import org.springframework.data.repository.CrudRepository;

import com.contact.domain.ContactPerson;

/**
 * @author Mahesh S
 *
 */
public interface JpaContactPersonRepository extends CrudRepository<ContactPerson, String> {
	
}
