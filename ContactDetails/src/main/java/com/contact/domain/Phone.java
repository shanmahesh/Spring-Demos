/**
 * 
 */
package com.contact.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
public class Phone {

	@Id
	@GeneratedValue
	private Long id;
	
	private String type;
	private String number;
	
}
