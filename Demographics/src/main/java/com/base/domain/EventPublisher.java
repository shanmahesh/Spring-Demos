/**
 * 
 */
package com.base.domain;

import java.io.Serializable;

/**
 * @author Mahesh S
 *
 */
public interface EventPublisher {

	   void publish(Serializable event);
}
