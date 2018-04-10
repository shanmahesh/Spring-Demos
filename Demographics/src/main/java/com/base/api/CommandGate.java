/**
 * 
 */
package com.base.api;

/**
 * @author Mahesh S
 *
 */
public interface CommandGate {
	public abstract Object dispatch(Object command);
}
