/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.embeddedZk;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.zookeeper.server.ServerConfig;
import org.apache.zookeeper.server.quorum.QuorumPeerConfig;

/**
 * @author tnguyen 2016-09-14
 * @version 1.0
 *
 */
public class ZookeeperLocal {

	ZooKeeperServerMainTopas zooKeeperServer;

	Thread zkThread;

	/**
	 * 
	 * @param zkProperties
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public ZookeeperLocal(Properties zkProperties, Object sync) throws FileNotFoundException, IOException {
		QuorumPeerConfig quorumConfiguration = new QuorumPeerConfig();
		try {
			quorumConfiguration.parseProperties(zkProperties);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		zooKeeperServer = new ZooKeeperServerMainTopas();
		final ServerConfig configuration = new ServerConfig();
		configuration.readFrom(quorumConfiguration);

		zkThread = new Thread() {
			public void run() {
				try {
					zooKeeperServer.runFromConfig(configuration);
					
					// notifier que zookeeper est prêt
					synchronized (sync) {
						System.out.println("------------ Zookeeper serveur est prêt!!");
						sync.notify();
					}
					
				} catch (IOException e) {
					System.out.println("ZooKeeper Failed");
					e.printStackTrace(System.err);
				}
			}
		};

		zkThread.start();
	}

	public void shutdown() {
		zooKeeperServer.shutdown();
	}
}