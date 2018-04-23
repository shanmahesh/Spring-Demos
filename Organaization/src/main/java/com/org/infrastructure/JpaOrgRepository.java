/**
 * 
 */
package com.org.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.org.domain.Org;

/**
 * @author Mahesh S
 *
 */
public interface JpaOrgRepository extends MongoRepository<Org, String> {

}
