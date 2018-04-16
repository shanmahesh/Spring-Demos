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

/**
 * @author Mahesh S
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventEnvelope implements Serializable{
	
	private String id;
	private String eventName;
	private byte[] eventEto;
	
	
	public void setEventEto(BaseEto baseEto){
		ObjectMapper mapper = new ObjectMapper();
		try {
			eventEto = mapper.writeValueAsBytes(baseEto);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Error sending ETO");
		}
		
	}

}
