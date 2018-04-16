/**
 * 
 */
package com.contact.api.listener;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.contact.cannonicalmodel.publishedlanguage.EventEnvelope;
import com.contact.cannonicalmodel.publishedlanguage.PersonEto;
import com.fasterxml.jackson.databind.ObjectMapper;



/**
 * @author Mahesh S
 *
 */
@Component
public class PersonCreatedEventListener {

	@KafkaListener(topics="${jsa.kafka.topic}")
    public void handle(String data) {
    	
    	try {
    		EventEnvelope event = new ObjectMapper().readValue(data, EventEnvelope.class);
			PersonEto p = new ObjectMapper().readValue(event.getEventEto(),PersonEto.class);
			System.out.println(" ***** Person ETO ##### ***** " + p.toString());
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
	}
	
}
