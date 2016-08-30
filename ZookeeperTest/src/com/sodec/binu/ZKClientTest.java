/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.binu;

/*
 * @(#)ZKClientTest.java
 * @author Binu George
 * Globinch.com
 * copyright http://www.java.globinch.com. All rights reserved.
 */
// package com.globinch.zoo.client.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * ZKClientTest Test Class
 * 
 * @author Binu George
 * @since 2016
 * @version 1.0
 * http://www.java.globinch.com. All rights reserved
 */
public class ZKClientTest {

	private static ZKClientManagerImpl zkmanager = new ZKClientManagerImpl();
	// ZNode Path
	private String path = "/QN-GBZnode";
	byte[] data = "www.java.globinch.com ZK Client Data".getBytes();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.globinch.zoo.client.ZKClientManagerImpl#create(java.lang.String, byte[])}
	 * .
	 * 
	 * @throws InterruptedException
	 * @throws KeeperException
	 */
	@Test
	public void testCreate() throws KeeperException, InterruptedException {
		// data in byte array
		
		zkmanager.create(path, data);
		Stat stat = zkmanager.getZNodeStats(path);
		assertNotNull(stat);
		zkmanager.delete(path);
	}

	/**
	 * Test method for
	 * {@link com.globinch.zoo.client.ZKClientManagerImpl#getZNodeStats(java.lang.String)}
	 * .
	 * 
	 * @throws InterruptedException
	 * @throws KeeperException
	 */
	@Test
	public void testGetZNodeStats() throws KeeperException,
			InterruptedException {
		zkmanager.create(path, data);
		Stat stat = zkmanager.getZNodeStats(path);
		assertNotNull(stat);
		assertNotNull(stat.getVersion());
		zkmanager.delete(path);

	}

	/**
	 * Test method for
	 * {@link com.globinch.zoo.client.ZKClientManagerImpl#getZNodeData(java.lang.String)}
	 * .
	 * @throws InterruptedException 
	 * @throws KeeperException 
	 */
	@Test
	public void testGetZNodeData() throws KeeperException, InterruptedException {
		zkmanager.create(path, data);
		String data = (String)zkmanager.getZNodeData(path,false);
		assertNotNull(data);
		zkmanager.delete(path);
	}

	/**
	 * Test method for
	 * {@link com.globinch.zoo.client.ZKClientManagerImpl#getZNodeChildren(java.lang.String)}
	 * .
	 * @throws InterruptedException 
	 * @throws KeeperException 
	 */
	static String value;

	@Test
	public void testWatchForChanges() throws KeeperException, InterruptedException {
		zkmanager.create(path, data);
		
		value = null;
		
		/**
		 * http://www.programcreek.com/java-api-examples/index.php?api=org.apache.zookeeper.AsyncCallback
		 */
		AsyncCallback.DataCallback cb = new AsyncCallback.DataCallback() {
		        String status = "not done";
		        public void processResult(int rc, String p, Object c, byte[] b, Stat s) {
		            synchronized(this) { 
		            	status = KeeperException.Code.get(rc).toString(); this.notify();
		            	
		            	value = p;
		            	
		            	System.out.println("====  nous avons value = " + value + "------" + p + " --status-->" + status);
		            	
		            	
		            }
		        }
		       public String toString() { return status; }
		};
		

		
		zkmanager.watchForChanges(path, cb);
		
		String newdata = "hello";
		
		System.out.println("====  nous updatons à " + newdata);
		zkmanager.update(path, newdata.getBytes());
		//zkeeper.setData(path, data, version);
		
		
		for (int count = 0; count < 100; count++) {
			if (value != null) {
				break;
			}
		}
		
		
		zkmanager.delete(path);
		
		
		assertEquals(newdata, value);
	}

	/**
	 * Test method for
	 * {@link com.globinch.zoo.client.ZKClientManagerImpl#update(java.lang.String, byte[])}
	 * .
	 * @throws InterruptedException 
	 * @throws KeeperException 
	 */
	@Test
	public void testUpdate() throws KeeperException, InterruptedException {
		zkmanager.create(path, data);
		String data = "www.java.globinch.com Updated Data";
		byte[] dataBytes = data.getBytes();
		zkmanager.update(path, dataBytes);
		String retrivedData = (String)zkmanager.getZNodeData(path,false);
		assertNotNull(retrivedData);
		zkmanager.delete(path);
	}

	/**
	 * Test method for
	 * {@link com.globinch.zoo.client.ZKClientManagerImpl#getZNodeChildren(java.lang.String)}
	 * .
	 * @throws InterruptedException 
	 * @throws KeeperException 
	 */
	@Test
	public void testGetZNodeChildren() throws KeeperException, InterruptedException {
		zkmanager.create(path, data);
		List<String> children= zkmanager.getZNodeChildren(path);
		assertNotNull(children);
		zkmanager.delete(path);
	}

	/**
	 * Test method for
	 * {@link com.globinch.zoo.client.ZKClientManagerImpl#delete(java.lang.String)}
	 * .
	 * @throws InterruptedException 
	 * @throws KeeperException 
	 */
	@Test
	public void testDelete() throws KeeperException, InterruptedException {
		zkmanager.create(path, data);
		zkmanager.delete(path);
		Stat stat = zkmanager.getZNodeStats(path);
		assertNull(stat);
	}

}