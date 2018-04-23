/**
 * 
 */
package com.org.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Mahesh S
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection="Orgs")
public class Org {

	@Id
	private String id;
	private String name;
	private String orgType;
	private String rptgunitType;
	
}
