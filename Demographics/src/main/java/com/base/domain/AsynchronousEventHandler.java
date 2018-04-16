/**
 * 
 */
package com.base.domain;

import java.lang.reflect.Method;

import javax.inject.Inject;


import org.springframework.beans.factory.BeanFactory;


/**
 * @author Mahesh S
 *
 */
public class AsynchronousEventHandler extends SpringEventHandler {

	/**
	 * @param eventType
	 * @param beanName
	 * @param method
	 * @param beanFactory
	 */
	public AsynchronousEventHandler(Class<?> eventType, String beanName,
			Method method, BeanFactory beanFactory) {
		super(eventType, beanName, method, beanFactory);
	}
	

	@Inject
	private MessageProducer messageProducer;
	
	@Override
    public void handle(Object event) {
	 
        //Object bean = this.beanFactory.getBean(beanName);
        
        messageProducer.Send(event);
        

    }

	
	
	
}
