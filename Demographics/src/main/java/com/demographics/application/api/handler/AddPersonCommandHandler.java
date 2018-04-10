/**
 * 
 */
package com.demographics.application.api.handler;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.base.api.CommandHandler;
import com.demographics.application.api.command.AddPersonCommand;
import com.demographics.application.api.dto.PersonDto;
import com.demographics.domain.Person;
import com.demographics.domain.PersonFactory;
import com.demographics.domain.PersonRepository;



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

	@Transactional
public PersonDto handle(AddPersonCommand personCommand) {
	Person person = personFactory.createPerson(personCommand.getPersonDto());
	personRepo.save(person);
	personCommand.getPersonDto().setPrsnId(person.getAggregateId().getId());
	return personCommand.getPersonDto();
}

}
