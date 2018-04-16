/**
 * 
 */
package com.base.domain;

import java.lang.reflect.Method;

import org.springframework.beans.factory.BeanFactory;

import lombok.Getter;

/**
 * @author Mahesh S
 *
 */
@Getter
public class SpringEventHandler implements EventHandler {
	 protected final Class<?> eventType;
	 protected final String beanName;
	 protected final Method method;
	 protected final BeanFactory beanFactory;

	    public SpringEventHandler(Class<?> eventType, String beanName, Method method, BeanFactory beanFactory) {
	        this.eventType = eventType;
	        this.beanName = beanName;
	        this.method = method;
	        this.beanFactory = beanFactory;
	    }

	    public boolean canHandle(Object event) {
	        return eventType.isAssignableFrom(event.getClass());
	    }

	    @Override
	    public void handle(Object event) {
	        Object bean = beanFactory.getBean(beanName);
	        try {
	            method.invoke(bean, event);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
