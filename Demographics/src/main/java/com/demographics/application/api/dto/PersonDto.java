/**
 * 
 */
package com.demographics.application.api.dto;

import java.util.Date;

import com.base.api.BaseDto;
import com.base.domain.AggregateId;

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
public class PersonDto extends BaseDto{

	private String prsnId;
	private String firstName;
	private String lastName;
	private String midName;
	private String SSN;
	private Date dob;
	
}
