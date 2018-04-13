/**
 * 
 */
package com.demographics.cannonicalmodel.events;

import java.io.Serializable;

import com.demographics.cannonicalmodel.publishedlanguage.PersonEto;

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
public class PersonCreatedEvent implements Serializable{
	private Object personEto;

	private byte[] dto;
	
}
