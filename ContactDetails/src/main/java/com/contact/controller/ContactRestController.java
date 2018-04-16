/**
 * 
 */
package com.contact.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.api.dto.ContactDto;
import com.contact.api.service.ContactServiceImpl;
import com.contact.cannonicalmodel.publishedlanguage.EventEnvelope;
import com.contact.cannonicalmodel.publishedlanguage.PersonEto;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Mahesh S
 *
 */
@RestController
public class ContactRestController {

	@Autowired
	private ContactServiceImpl contactService;
	
	@RequestMapping("/addContact")
	public ContactDto addContact(@RequestBody ContactDto contactDto) {
		contactService.addContact(contactDto);
		return contactDto;
	} 
	
	
	
	@KafkaListener(topics="${jsa.kafka.topic}")
	public void processMessage(String content) throws JsonParseException, JsonMappingException, IOException {
		//log.info("received content = '{}'", content);
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		EventEnvelope ev = mapper.readValue(content, EventEnvelope.class);
		PersonEto p = mapper.readValue(ev.getEventEto(), PersonEto.class);
		
		System.out.println(ev.toString() + "Message Received event in contact *** ::: " + p.toString());
		
		/*try {
			
			
			//PersonCreatedEvent event = mapper.readValue(content,PersonCreatedEvent.class);
			System.out.println("Message Received event in contact *** ::: " + content);
			
			//PersonEto eto =  (PersonEto)  mapper.readValue(event.getDto(),PersonEto.class);
			
			//System.out.println("Message Received ETO**::: " + eto.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
    }
	
}
