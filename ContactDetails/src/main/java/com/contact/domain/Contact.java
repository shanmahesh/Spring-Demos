/**
 * 
 */
package com.contact.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author Mahesh S
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contact {

	@Id
	private String Id;
	private String emailId;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="contact_id")
	private Set<Phone> phones = new HashSet<Phone>();
	
	@OneToOne
	private ContactPerson person;

}
