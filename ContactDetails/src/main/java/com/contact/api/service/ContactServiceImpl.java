/**
 * 
 */
package com.contact.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.api.dto.ContactDto;
import com.contact.cannonicalmodel.publishedlanguage.PersonEto;
import com.contact.domain.Contact;
import com.contact.domain.ContactFactory;
import com.contact.domain.ContactPerson;
import com.contact.domain.ContactRepository;
import com.contact.infrastructure.JpaContactPersonRepository;

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
	
	@Autowired 
	private JpaContactPersonRepository jpaContactPersonRepository;
	
	public void addContact(ContactDto contactDto) {
		
		Contact contact = contactFactory.createContact(contactDto);
		
		contactRepo.save(contact);
		
	}
	
	
	public void createContactPerson(PersonEto personEto) {
		
		Optional<ContactPerson> contactPerson = jpaContactPersonRepository.findById(personEto.getPrsnId());
				
		if(contactPerson.isPresent()) {
			contactPerson.get().setFirstName(personEto.getFirstName());
			contactPerson.get().setLastName(personEto.getLastName());
			jpaContactPersonRepository.save(contactPerson.get());
			
		}else {
			ContactPerson cp = new ContactPerson();
			cp.setPrsnId(personEto.getPrsnId());
			cp.setFirstName(personEto.getFirstName());
			cp.setLastName(personEto.getLastName());
			jpaContactPersonRepository.save(cp);
		}
		

		
	}
	
}
