/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.embeddedZk;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.zookeeper.ZooKeeper;

/**
 * @author tnguyen 2016-09-14
 * @version 1.0
 *
 */

public class TestEmbedded {

	public static void main(String[] args) throws Exception {
		String port = "2199";
		Properties props = new Properties();
		props.setProperty("dataDir", "c:/TDEV/zookeeper-3.4.8/ZOO-DATA");
		props.setProperty("clientPort", port);

		Object sync = new Object();
		ZookeeperLocal zkLocal = new ZookeeperLocal(props, sync); // démarrer
																	// zookeeper

		synchronized (sync) {

			try {
				System.out.println("Attente ............... de zookeeper");
				sync.wait();
			} catch (InterruptedException  e) {
				// TODO Bloque 'catch' auto-généré
				e.printStackTrace();
			}

			ZkConnectDeepakOLD connector = new ZkConnectDeepakOLD();
			ZooKeeper zk = connector.connect("127.0.0.1:" + port); // 54.169.132.0,52.74.51.0");
			String newNode = "/deepakDate" + new Date();
			connector.createNode(newNode, new Date().toString().getBytes());
			List<String> zNodes = zk.getChildren("/", true);
			for (String zNode : zNodes) {
				System.out.println("ChildrenNode " + zNode);
			}
			byte[] data = zk.getData(newNode, true, zk.exists(newNode, true));
			System.out.println("GetData before setting");
			for (byte dataPoint : data) {
				System.out.print((char) dataPoint);
			}

			System.out.println("GetData after setting");
			connector.updateNode(newNode, "Modified data".getBytes());
			data = zk.getData(newNode, true, zk.exists(newNode, true));
			for (byte dataPoint : data) {
				System.out.print((char) dataPoint);
			}
			connector.deleteNode(newNode);
		}

		zkLocal.shutdown();

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
