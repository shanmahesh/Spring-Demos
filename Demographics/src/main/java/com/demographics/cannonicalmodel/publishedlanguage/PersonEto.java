/**
 * 
 */
package com.demographics.cannonicalmodel.publishedlanguage;

import java.util.Date;

import com.base.api.BaseEto;

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
public class PersonEto extends BaseEto{
	private String prsnId;
	private String firstName;
	private String lastName;
	private String midName;
	private String SSN;
	private Date dob;
	
}
