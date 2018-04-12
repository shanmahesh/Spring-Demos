/**
 * 
 */
package com.base.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;


/**
 * @author Mahesh S
 *
 */
@Component
public class EventPublisherImpl implements EventPublisher{

	 private Set<EventHandler> eventHandlers = new HashSet<EventHandler>();

	    public void registerEventHandler(EventHandler handler) {
	        eventHandlers.add(handler);
	        // new SpringEventHandler(eventType, beanName, method));
	    }

	    @Override
	    public void publish(Serializable event) {
	        doPublish(event);
	    }

	    protected void doPublish(Object event) {
	        for (EventHandler handler : new ArrayList<EventHandler>(eventHandlers)) {
	            if (handler.canHandle(event)) {
	                try {
	                    handler.handle(event);
	                } catch (Exception e) {
	                    //LOGGER.error("event handling error", e);
	                }
	            }
	        }
	    }
	
}
