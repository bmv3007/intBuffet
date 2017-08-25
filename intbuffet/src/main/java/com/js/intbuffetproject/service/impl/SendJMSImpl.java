package com.js.intbuffetproject.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.js.intbuffetproject.service.SendJMS;

@Component
public class SendJMSImpl implements SendJMS {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public void sendJMS() {
		
		 jmsTemplate.send(new MessageCreator() {
	            public Message createMessage(Session session) throws JMSException {
	            
	                return session.createTextMessage("The Products were changed!");
	            }
	        });
			
	}

}
