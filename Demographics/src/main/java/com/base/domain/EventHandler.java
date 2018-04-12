/**
 * 
 */
package com.base.domain;

/**
 * @author Mahesh S
 *
 */
public interface EventHandler {
    boolean canHandle(Object event);

    void handle(Object event);
}