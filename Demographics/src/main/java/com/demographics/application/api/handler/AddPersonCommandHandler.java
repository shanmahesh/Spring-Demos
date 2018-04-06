/**
 * 
 */
package com.demographics.application.api.handler;

import com.base.api.CommandHandler;
import com.demographics.application.api.command.AddPersonCommand;
import com.demographics.application.api.dto.PersonDto;



/**
 * @author Mahesh S
 *
 */


public class AddPersonCommandHandler implements CommandHandler<AddPersonCommand, PersonDto>{

public PersonDto handle(AddPersonCommand personCommand) {
	
	return null;
}

}
