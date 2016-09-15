/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.embeddedZk.binuGlobinch;

/*
 * @(#)ZKClientTest.java
 * @author Binu George
 * Globinch.com
 * copyright http://www.java.globinch.com. All rights reserved.
 */
//package com.globinch.zoo.client.test;
import static org.junit.Assert.*;

import com.sodec.embeddedZk.deepak.ZooKeeperServerEmbedded;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

//import com.globinch.zoo.client.ZKClientManagerImpl;

/**
 * ZKClientTest Test Class
 * 
 * @author Binu George
 * @since 2016
 * @version 1.0
 * http://www.java.globinch.com. All rights reserved
 */
public class ZKTest {
	private static String host = "localhost";
	private static int port = 2222;

	private static ZooKeeperServerEmbedded zkServeur;
	private static ZKManager zkmanager;
	private String path = "/node-topas-de-test";
	byte[] data = "données de test Topas".getBytes();

	/**
	 * Démarrer le serveur Zookeeper embeddé.
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpClass() throws Exception {
		zkServeur = new ZooKeeperServerEmbedded(port); // démarrer le serveur zookeeper
		zkServeur.demarre();
		
		zkmanager = new ZKClientManagerImpl();	// ZNode Path
		zkmanager.connect(host + ":" + port);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownClass() throws Exception {
		zkServeur.shutdown();
	}
	
	@Before
	public void setUp() throws KeeperException, InterruptedException {
		zkmanager.create(path, data);
	}
	
	@After
	public void tearDown() throws KeeperException, InterruptedException {
		zkmanager.delete(path);
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
		Stat stat = zkmanager.getZNodeStats(path);
		assertNotNull(stat);
	}

	/**
	 * Test method for
	 * {@link com.globinch.zoo.client.ZKClientManagerImpl#create(java.lang.String, byte[])}
	 * .
	 * 
	 * @throws InterruptedException
	 * @throws KeeperException
	 */
	String valeurRecue;
	@Test
	public void testObservation() throws KeeperException, InterruptedException {
		
		String donnees = "valeur initiale";
		String donneesMisAJour = "valeur mis à jour";
		String pathObservee =  "/node-topas-observee";

		zkmanager.create(pathObservee, donnees.getBytes());
		Stat stat = zkmanager.getZNodeStats(path);
		assertNotNull(stat);
		
		// le compteur sera libéré après que l'observateur soit invoqué
		CountDownLatch compteur = new CountDownLatch(1);
				
		// Créer un observateur
		Observateur observateur = new Observateur() {

			// le répertoire est mis-à-jour: notre observateur est invoqué
			@Override
			public void traiter(String path, String valeur) {
				System.out.format("Notre path '%s' est changé à '%s'", path, valeur);
				valeurRecue = valeur;
				compteur.countDown();// libérer le compteur
			}			
		};
		
		zkmanager.observer(path, observateur);
		
		// modifier le node pour provoquer l'appel de notre observateur
		zkmanager.update(path, donneesMisAJour.getBytes());
	
		try {
			compteur.await(2, TimeUnit.SECONDS);// attendre 2 secondes max
			
		} catch (InterruptedException ex) {
			fail("Attente trop long");// échouer le test pcq attente trop longue
			return;
		}

		// vérifier la valeur reçue
		assertTrue(valeurRecue.equals(donneesMisAJour));
		zkmanager.delete(pathObservee);
		
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
		Stat stat = zkmanager.getZNodeStats(path);
		assertNotNull(stat);
		assertNotNull(stat.getVersion());
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
		String data = (String)zkmanager.getZNodeData(path,false);
		assertNotNull(data);
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
		String data = "données mis à jour";
		byte[] dataBytes = data.getBytes();
		zkmanager.update(path, dataBytes);
		String retrivedData = (String)zkmanager.getZNodeData(path,false);
		assertNotNull(retrivedData);
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

		List<String> children= zkmanager.getZNodeChildren(path);
		assertNotNull(children);
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
		zkmanager.delete(path);
		Stat stat = zkmanager.getZNodeStats(path);
		assertNull(stat);
	}

}