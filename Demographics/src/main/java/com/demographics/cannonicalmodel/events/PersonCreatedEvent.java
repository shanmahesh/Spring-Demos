/**
 * 
 */
package com.demographics.cannonicalmodel.events;

import java.io.Serializable;

import com.base.annotations.Event;
import com.base.api.EventEnvelope;
import com.demographics.cannonicalmodel.publishedlanguage.PersonEto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Mahesh S
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Event(asynchronous=true)
public class PersonCreatedEvent extends EventEnvelope {
		
}
