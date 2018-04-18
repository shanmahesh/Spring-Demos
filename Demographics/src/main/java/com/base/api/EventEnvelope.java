/**
 * 
 */
package com.base.api;

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
	
	public void setEventEto(String baseEto){
		this.eventEto = baseEto;
	}
	
	public void setEventEto(Object baseEto){
		ObjectMapper mapper = new ObjectMapper();
		try {
			eventEto = mapper.writeValueAsString(baseEto);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Error sending ETO");
		}
		
	}

}
