/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.embeddedZk.deepak;

import java.util.Date;
import java.util.List;

import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tnguyen 2016-09-14
 * @version 1.0
 *
 */

public class TestEmbedded {
	
	private static Logger logger = LoggerFactory.getLogger(TestEmbedded.class.getName());

	public static void main(String[] args) throws Exception {

		/**
		 * Démarrer le serveur
		 */
		int port = 2222;
		ZooKeeperServerEmbedded zkServeur = new ZooKeeperServerEmbedded(port); // démarrer
																				// zookeeper
		zkServeur.demarre();

		/**
		 * Faire nos tests
		 */
		ZkConnectDeepak connector = new ZkConnectDeepak();
		ZooKeeper zkClient = connector.connect("127.0.0.1:" + port); // 54.169.132.0,52.74.51.0");
		String newNode = "/deepakDate" + new Date();
		connector.createNode(newNode, new Date().toString());
		List<String> zNodes = zkClient.getChildren("/", true);
		for (String zNode : zNodes) {
			logger.info("===========================ChildrenNode " + zNode);
		}
		
		
		byte[] data = zkClient.getData(newNode, true, zkClient.exists(newNode, true));
		System.out.println("GetData before setting");
		

		System.out.println("GetData after setting");
		connector.updateNode(newNode, "this is the Modified data".getBytes());
		data = zkClient.getData(newNode, true, zkClient.exists(newNode, true));
		for (byte dataPoint : data) {
			System.out.print((char) dataPoint);
		}
		logger.info("================== " + new String(data));
		connector.deleteNode(newNode);
		// }

		/**
		 * Imp/
		 */
		testWatch(connector);
		
		
		/**
		 * Arrêter le serveur
		 */
		zkServeur.shutdown();

	}

	/**
	 * Teste la surveillance d'une répertoire.
	 */
	/**
	 * @param connector
	 * @throws Exception
	 */
	/**
	 * @param connector
	 * @throws Exception
	 */
	private static void testWatch(ZkConnectDeepak connector) throws Exception {
		String monWatchDir = "/MonWatchDir";
		
		
		try {
			// CREATE A NOTDE
			connector.createNode(monWatchDir, "contenu 3333 " + new Date().toString());
		} catch (Exception e) {
			// TODO Bloque 'catch' auto-généré
			e.printStackTrace();
		}
	
		// ajouter un watch sur le dossier
		
	}

	// /**
	// *
	// */
	// public TestEmbedded() {
	// // TODO Constructeur de substitut auto-générée
	// }
	//
	//
	// QuorumPeerConfig conf = new QuorumPeerConfig();
	// conf.
	// runZKServer(zkConfig);
	// }
	//
	// private static void runZKServer(QuorumPeerConfig zkConfig) throws
	// UnknownHostException, IOException {
	// if (zkConfig.isDistributed()) {
	// QuorumPeerMain qp = new QuorumPeerMain();
	// qp.runFromConfig(zkConfig);
	// } else {
	// ZooKeeperServerMain zk = new ZooKeeperServerMain();
	// ServerConfig serverConfig = new ServerConfig();
	// serverConfig.readFrom(zkConfig);
	// zk.runFromConfig(serverConfig);
	// }
	// }
	//
}
