/**
 * 
 */
package com.contact.domain;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.contact.api.dto.ContactDto;
import com.contact.api.dto.PhoneDto;

/**
 * @author Mahesh S
 *
 */
@Component
public class ContactFactory {

	public Contact createContact(ContactDto contactDto) {
		Contact contact = new  Contact();
		//BeanUtils.copyProperties(contactDto, contact);
		contact.setId(UUID.randomUUID().toString());
		contact.setEmailId(contactDto.getEmailId());
		for(PhoneDto dto : contactDto.getPhones()) {
			Phone p = new Phone();
			BeanUtils.copyProperties(dto,p);
			contact.getPhones().add(p);
		}
		
		return contact;
		
	}
	
}
