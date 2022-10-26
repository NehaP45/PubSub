package com.example.sub1;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import com.example.model.Patient;

public class sub1 {
	
	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		
		
	InitialContext ctx = new InitialContext();
	Topic t=(Topic) ctx.lookup("topic/empTopic");
	
	try{
		
		ActiveMQConnectionFactory cf=new ActiveMQConnectionFactory();
		 JMSContext js=cf.createContext();
		
		JMSConsumer cons = js.createConsumer(t);
		Message m=cons.receive();
		Patient p = m.getBody(Patient.class);
		System.out.println("messege is recieved");
		System.out.println("name of patient is "+p.getName());

}
	catch(Exception e)
	{
		
	}
	
	}
}
