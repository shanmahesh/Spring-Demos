/**
 * 
 */
package com.contact.cannonicalmodel.publishedlanguage;



import java.util.Date;



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
public class PersonEto {
	private String prsnId;
	private String firstName;
	private String lastName;
	private String midName;
	private String SSN;
	private Date dob;
	
}
