package com.example.publisher;

import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import com.example.model.Patient;

public class publisher {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		
		
	InitialContext ctx = new InitialContext();
	Topic t=(Topic) ctx.lookup("topic/empTopic");
	
	try{
		
		ActiveMQConnectionFactory cf=new ActiveMQConnectionFactory();
		 JMSContext js=cf.createContext();
		 Patient p=new Patient();
		 p.setId(1);
		p.setName("Abc");
		p.setPayDue(1000);
		p.setPaymentString(20000);
		js.createProducer().send(t, p);
		System.out.println("messege is send");

	}
	catch(Exception e) {
	System.out.println("Exception occured while publishing messege"+e);
	}

}
}
