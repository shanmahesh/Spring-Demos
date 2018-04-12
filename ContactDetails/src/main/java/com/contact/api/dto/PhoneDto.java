/**
 * 
 */
package com.contact.api.dto;



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
public class PhoneDto {

	private Long id;
	
	private String type;
	private String number;
	
	
}
