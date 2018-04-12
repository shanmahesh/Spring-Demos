/**
 * 
 */
package com.contact.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.api.dto.ContactDto;
import com.contact.domain.Contact;
import com.contact.domain.ContactFactory;
import com.contact.domain.ContactRepository;

/**
 * @author Mahesh S
 *
 */
@Service
public class ContactServiceImpl {

	@Autowired
	private ContactFactory contactFactory;
	
	@Autowired 
	private ContactRepository contactRepo;
	
	public void addContact(ContactDto contactDto) {
		
		Contact contact = contactFactory.createContact(contactDto);
		
		contactRepo.save(contact);
		
	}
	
	
}
