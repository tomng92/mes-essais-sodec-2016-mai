package com.example.switchyard.switchyard_example.test;

import javax.xml.namespace.QName;

import org.switchyard.remote.RemoteInvoker;
import org.switchyard.remote.RemoteMessage;
import org.switchyard.remote.http.HttpInvoker;

/**
 * See Gary Liu's article.
 * http://ggl-consulting.blogspot.ca/2015/05/jboss-fsw-development-tutorial.html
 * 
 * Note: this does not work!!!
 * See Test1Bean
 * 
 * @author tnguyen Mai 13 2016
 *
 */

public class MyTestRemoteClient {
	
	  private static final QName SERVICE = new QName(
	            "urn:com.example.switchyard.switchyard_example:switchyard-example:1.0",
	            "Test1");
	    private static final String URL = "http://localhost:8080/switchyard-example";
	 
	    /**
	     * Private no-args constructor.
	     */
	    private MyTestRemoteClient() {
	    }
	 
	    /**
	     * Only execution point for this application.
	     * @param ignored not used.
	     * @throws Exception if something goes wrong.
	     */
	    public static void main(final String[] ignored) throws Exception {
	        // Create a new remote client invoker
	        RemoteInvoker invoker = new HttpInvoker(URL);
	 
	 
	        RemoteMessage message = new RemoteMessage();
	        message.setService(SERVICE).setOperation("sayHello").setContent("My Dear Earth");
	 
	        // Invoke the service
	        RemoteMessage reply = invoker.invoke(message);
	        if (reply.isFault()) {
	            System.err.println("Oops ... something bad happened.  "
	                    + reply.getContent());
	        } else {
	            String greeting = (String) reply.getContent();
	            System.out.println("==================================");
	            System.out.println("Got reply from HelloWorld Service: " + greeting);
	            System.out.println("==================================");
	        }
	    }
	 
	 
}
