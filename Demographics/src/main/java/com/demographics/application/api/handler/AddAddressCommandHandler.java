/**
 * 
 */
package com.demographics.application.api.handler;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.base.api.CommandHandler;
import com.base.domain.AggregateId;
import com.demographics.application.api.command.AddAddressCommand;
import com.demographics.application.api.command.AddPersonCommand;
import com.demographics.application.api.dto.AddressDto;
import com.demographics.application.api.dto.PersonDto;
import com.demographics.domain.Person;
import com.demographics.domain.PersonFactory;
import com.demographics.domain.PersonRepository;



/**
 * @author Mahesh S
 *
 */

@Component
public class AddAddressCommandHandler implements CommandHandler<AddAddressCommand, AddressDto>{

	@Inject
	public PersonFactory personFactory;
	
	@Inject
	public PersonRepository personRepo;

	@Transactional
public AddressDto handle(AddAddressCommand addressCommand) {
	Person person = personRepo.load(new AggregateId(addressCommand.getAddressDto().getPrsnId()));
	person.addAddress(addressCommand.getAddressDto());
	
	personRepo.save(person);
	
	
	return addressCommand.getAddressDto();
}

}
