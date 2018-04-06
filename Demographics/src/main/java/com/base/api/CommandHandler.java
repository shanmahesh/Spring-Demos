/**
 * 
 */
package com.base.api;

/**
 * @author Mahesh S
 *
 */
public interface CommandHandler<C, R> {

    public R handle(C command);
}