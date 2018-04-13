/**
 * 
 */
package com.demographics.application.api.listener;

import org.springframework.stereotype.Component;

import com.demographics.cannonicalmodel.events.PersonCreatedEvent;

/**
 * @author Mahesh S
 *
 */
@Component
public class PersonCreatedListener {

	
	@com.base.annotations.EventListener(asynchronous = false)
    public void handle(PersonCreatedEvent event) {
		System.out.println(" ***** Person ETO ***** " + event.getPersonEto().toString());
	}
	
	
}
