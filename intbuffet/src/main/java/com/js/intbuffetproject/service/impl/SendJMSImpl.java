package com.js.intbuffetproject.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.js.intbuffetproject.service.SendJMS;

/**
 * Class SendJMSImpl sends message to ActiveMQ.
 * 
 * @author Maria Borovtsova
 * 
 * @version 1.1
 */
@Component
public class SendJMSImpl implements SendJMS {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public void sendJMS() {
		
		 jmsTemplate.send(new MessageCreator() {
	            public Message createMessage(Session session) throws JMSException {
	              
	            	TextMessage message = session.createTextMessage("The Products were changed!");
	            	
	                return message;
	            }
	        });
			
	}

}
