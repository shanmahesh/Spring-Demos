/**
 * 
 */
package com.demographics.application.api.listener;

import org.springframework.stereotype.Component;

import com.base.annotations.EventListener;
import com.demographics.cannonicalmodel.events.PersonCreatedEvent;

/**
 * @author Mahesh S
 *
 */
@Component
public class PersonCreatedListener {

	
	@EventListener(asynchronous = false)
    public void handle(PersonCreatedEvent event) {
		System.out.println(" ***** Person ETO ***** " + event.getEventEto().toString());
	}
	
	
}
