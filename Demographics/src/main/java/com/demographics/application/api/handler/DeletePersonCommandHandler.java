/**
 * 
 */
package com.demographics.application.api.handler;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.base.api.CommandHandler;
import com.base.domain.AggregateId;
import com.demographics.application.api.command.AddPersonCommand;
import com.demographics.application.api.command.DeletePersonCommand;
import com.demographics.application.api.command.EditPersonCommand;
import com.demographics.application.api.dto.PersonDto;
import com.demographics.domain.Person;
import com.demographics.domain.PersonFactory;
import com.demographics.domain.PersonRepository;

/**
 * @author Mahesh S
 *
 */
@Component
public class DeletePersonCommandHandler implements CommandHandler<DeletePersonCommand, PersonDto> {

	@Inject
	public PersonFactory personFactory;
	
	@Inject
	public PersonRepository personRepo;

	@Transactional
public PersonDto handle(DeletePersonCommand personCommand) {
		Person person = personRepo.load(new AggregateId(personCommand.getPersonDto().getPrsnId()));
		if(person.canDelete()) {
			person.markAsRemoved();
			personRepo.save(person);
		}
			
	return null;
}
	
	
}
