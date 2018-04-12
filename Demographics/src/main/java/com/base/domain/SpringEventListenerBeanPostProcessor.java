/**
 * 
 */
package com.base.domain;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.base.annotations.EventListener;



/**
 * @author Mahesh S
 *
 */
@Component
public class SpringEventListenerBeanPostProcessor implements BeanPostProcessor, BeanFactoryAware {
	private BeanFactory beanFactory;
    private EventPublisherImpl eventPublisher;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!(bean instanceof SagaInstance)) {
            for (Method method : bean.getClass().getMethods()) {
            	EventListener listenerAnnotation = method.getAnnotation(EventListener.class);            	
                
            	if (listenerAnnotation == null) {
                    continue;
                }
                
            	Class<?> eventType = method.getParameterTypes()[0];
                
                if (listenerAnnotation.asynchronous()){
                	//TODO just a temporary fake impl
                	//EventHandler handler = new AsynchronousEventHandler(eventType, beanName, method, beanFactory);
                	//TODO add to some queue
                	//eventPublisher.registerEventHandler(handler);                	
                }
                else{                
                	EventHandler handler = new SpringEventHandler(eventType, beanName, method, beanFactory);
                	eventPublisher.registerEventHandler(handler);
                }                                
            }
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // do nothing
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        eventPublisher = beanFactory.getBean(EventPublisherImpl.class);
    }
}
