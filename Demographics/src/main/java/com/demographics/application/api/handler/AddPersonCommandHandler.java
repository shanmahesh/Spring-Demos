/**
 * 
 */
package com.demographics.application.api.handler;

import java.io.IOException;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.base.api.CommandHandler;
import com.base.domain.EventPublisher;
import com.demographics.KafkaProducer;
import com.demographics.application.api.command.AddPersonCommand;
import com.demographics.application.api.dto.PersonDto;
import com.demographics.cannonicalmodel.events.PersonCreatedEvent;
import com.demographics.cannonicalmodel.publishedlanguage.PersonEto;
import com.demographics.domain.Person;
import com.demographics.domain.PersonFactory;
import com.demographics.domain.PersonRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



/**
 * @author Mahesh S
 *
 */

@Component
public class AddPersonCommandHandler implements CommandHandler<AddPersonCommand, PersonDto>{

	@Inject
	public PersonFactory personFactory;
	
	@Inject
	public PersonRepository personRepo;

	@Inject
	public EventPublisher eventPublisher;
	
	@Inject
	private KafkaProducer kafkaProducer;
	
	@Transactional
public PersonDto handle(AddPersonCommand personCommand) {
	Person person = personFactory.createPerson(personCommand.getPersonDto());
	personRepo.save(person);
	personCommand.getPersonDto().setPrsnId(person.getAggregateId().getId());
	PersonEto personEto = new PersonEto();
	BeanUtils.copyProperties(personCommand.getPersonDto(), personEto);
	
	ObjectMapper mapper = new ObjectMapper();	
	PersonCreatedEvent event = new PersonCreatedEvent();
	event.setPersonEto(personEto);
	
	//eventPublisher.publish(event);

	

	try {
		event.setDto(mapper.writeValueAsBytes(personEto));
		kafkaProducer.send(mapper.writeValueAsString(event));
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return personCommand.getPersonDto();
}

	
	
	@KafkaListener(topics="${jsa.kafka.topic}")
    public void processMessage1(String content) {
		//log.info("received content = '{}'", content);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			
			PersonCreatedEvent event = mapper.readValue(content,PersonCreatedEvent.class);
			System.out.println("Message Received event::: " + event.toString());
			
			PersonEto eto =  (PersonEto)  mapper.readValue(event.getDto(),PersonEto.class);
			
			System.out.println("Message Received ETO**::: " + eto.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }
	
}
