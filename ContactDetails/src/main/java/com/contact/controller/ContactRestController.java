/**
 * 
 */
package com.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.api.dto.ContactDto;
import com.contact.api.service.ContactServiceImpl;

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
	
	
}
