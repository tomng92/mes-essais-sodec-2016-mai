/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.embeddedZk.deepak;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZkConnectDeepak {
	private ZooKeeper zk;

	// host should be 127.0.0.1:3000,127.0.0.1:3001,127.0.0.1:3002
	public ZooKeeper connect(String host) throws Exception {
		
		CountDownLatch connSignal = new CountDownLatch(1);
		
		zk = new ZooKeeper(host, 3000, new Watcher() {
			public void process(WatchedEvent event) {
				if (event.getState() == KeeperState.SyncConnected) {
					connSignal.countDown();
				}
			}
		});
		
		connSignal.await();
		return zk;
	}

	public void close() throws InterruptedException {
		zk.close();
	}

	public void createNode(String path, String data) throws Exception {
		byte[] dataByte = data.getBytes();
		zk.create(path, dataByte, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}

	public void updateNode(String path, byte[] data) throws Exception {
		zk.setData(path, data, zk.exists(path, true).getVersion());
	}

	public void deleteNode(String path) throws Exception {
		zk.delete(path, zk.exists(path, true).getVersion());
	}
	
	public String lire(String path) throws Exception {
		byte[] data = zk.getData(path, false, null);
		return new String(data);
	}
	

}