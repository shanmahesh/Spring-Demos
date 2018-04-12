/**
 * 
 */
package com.contact.api.dto;

import java.util.HashSet;
import java.util.Set;

import com.contact.domain.Phone;

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
public class ContactDto {

	private String Id;
	private String emailId;
		
	private Set<PhoneDto> phones = new HashSet<PhoneDto>();
	
	
}
