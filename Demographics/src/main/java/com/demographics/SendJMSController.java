package com.demographics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/")
public class SendJMSController {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@RequestMapping(path="Send")	
	public String SendMessage() {
		//JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
	    // Send a message with a POJO - the template reuse the message converter
		System.out.println("Sending an email message.");
	   jmsTemplate.convertAndSend("mailbox", "My first message");
		
	   
	   jmsTemplate.convertAndSend("Myintegerbox", new Integer(100));
	   
	   return "Success";
	}
	
	
}
