/**
 * 
 */
package com.contact.cannonicalmodel.publishedlanguage;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
public class EventEnvelope implements Serializable{
	
	private String id;
	private String eventName;
	private String eventEto;
	
	
	

}
