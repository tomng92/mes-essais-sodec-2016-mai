/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.embeddedZk.deepak;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.zookeeper.server.NIOServerCnxnFactory;
import org.apache.zookeeper.server.ServerCnxnFactory;
import org.apache.zookeeper.server.ZooKeeperServer;


/**
 * Un ZooKeeper local qui permet de faire des unit tests.
 * Voir http://stackoverflow.com/questions/9286054/
 * 				is-it-possible-to-start-a-zookeeper-server-instance-in-process-say-for-unit-tes
 * 
 * @author tnguyen 2016-09-14
 * @version 1.0
 *
 */
public class ZooKeeperServerEmbedded {

	private ServerCnxnFactory factory;
	private int port; // port client
	
	/**
	 * Constructeur.
	 * @param port
	 */
	public ZooKeeperServerEmbedded(int port) {
		this.port = port;
	}
	

	/**
	 * Démarre le serveur embeddé.
	 * See http://stackoverflow.com/questions/9286054/is-it-possible-to-start-a-
	 *        zookeeper-server-instance-in-process-say-for-unit-tes
	 * 
	 * @param port Il est recommandé d'utiliser un port autre que 2181 qui est le port standard.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void demarre() throws IOException {
		int numConnections = 5000;
		int tickTime = 2000;
		String dataDirectory = System.getProperty("java.io.tmpdir");

		File dir = new File(dataDirectory, "zookeeper").getAbsoluteFile();
		
		ZooKeeperServer server = new ZooKeeperServer(dir, dir, tickTime);
		factory = new NIOServerCnxnFactory();
		factory.configure(new InetSocketAddress(port), numConnections);

		try {
			factory.startup(server); // start the server.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Arrêter zookeeper.
	 */
	public void shutdown() {
		factory.shutdown();
	}
}
