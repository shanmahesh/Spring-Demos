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
import com.base.api.EventEnvelope;
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
import com.fasterxml.jackson.databind.DeserializationFeature;
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
	

	PersonCreatedEvent event = new PersonCreatedEvent();
	event.setEventName("PersonCreatedEvent");
	event.setEventEto(personEto);

	eventPublisher.publish(event);
	//kafkaProducer.send(event);
	
	
	return personCommand.getPersonDto();
}

	
	
	@KafkaListener(topics="${jsa.kafka.topic}")
    public void processMessage(String content) {
		//log.info("received content = '{}'", content);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
			
			
			PersonCreatedEvent event = mapper.readValue(content,PersonCreatedEvent.class);
			System.out.println("Message Received event::: " + event.toString());
			
			PersonEto eto =  (PersonEto)  mapper.readValue(event.getEventEto(),PersonEto.class);
			
			System.out.println("Message Received ETO**::: " + eto.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }
	
}
