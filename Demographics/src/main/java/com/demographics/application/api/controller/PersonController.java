/**
 * 
 */
package com.demographics.application.api.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.base.api.CommandGate;
import com.base.domain.AggregateId;
import com.demographics.application.api.command.AddPersonCommand;
import com.demographics.application.api.command.DeletePersonCommand;
import com.demographics.application.api.command.EditPersonCommand;
import com.demographics.application.api.dto.PersonDto;
import com.demographics.readmodel.PersonFinder;

/**
 * @author Mahesh S
 *
 */
@RestController
public class PersonController {

@Autowired
private  PersonFinder personFinder;

@Inject
private CommandGate gate;
	
	/*
	@RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
	*/
	@RequestMapping("/personDetails")
	public ResponseEntity getPersonDetails(@RequestParam(value="prsnId", defaultValue="") String prsnId) throws Exception{
	
			PersonDto dto = personFinder.getPersonDetails(new AggregateId("prsnId"));
			return new ResponseEntity(dto,HttpStatus.OK);
	}
	
	
	@RequestMapping("/person")
	public ResponseEntity getPersons() throws Exception{
	
			List<PersonDto> persons = personFinder.getPersons();
			return new ResponseEntity(persons,HttpStatus.OK);
	}
	
	
	
	@RequestMapping("/addPerson")
	public ResponseEntity addPerson(@RequestBody PersonDto personDto) throws Exception{
		AddPersonCommand personCommand = new AddPersonCommand(personDto);
			
		personDto = (PersonDto) gate.dispatch(personCommand); 
			return new ResponseEntity(personDto,HttpStatus.OK);
	}
	
	
	@RequestMapping("/editPerson/{prsnId}")
	public ResponseEntity editPerson(@PathVariable String prsnId, @RequestBody PersonDto personDto) throws Exception{
	
		personDto.setPrsnId(prsnId);
		EditPersonCommand personCommand = new EditPersonCommand(personDto);
		personDto = (PersonDto) gate.dispatch(personCommand);
			return new ResponseEntity(personDto,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deletePerson/{prsnId}")
	public ResponseEntity deletePerson(@PathVariable String prsnId) throws Exception{
		PersonDto personDto = new PersonDto();
		personDto.setPrsnId(prsnId);
		DeletePersonCommand personCommand = new DeletePersonCommand(personDto);
		gate.dispatch(personCommand);
	return new ResponseEntity(HttpStatus.OK);
	}
	
	
}
