/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.embeddedZk.binuGlobinch;

/*
 * @(#)ZKClientManagerImpl.java
 * @author Binu George
 * Globinch.com
 * copyright http://www.java.globinch.com. All rights reserved.
 */
//package com.sodec.embeddedZk.binuGlobinch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * ZKClientManagerImpl class. Implements the methods to manipulate znodes.
 * 
 * @author Binu George
 * @since 2016
 * @version 1.0 http://www.java.globinch.com. All rights reserved
 */
public class ZKClientManagerImpl implements ZKManager {

	private static ZooKeeper zkeeper;

	private static ZKConnection zkConnection;

	/**
	 * Close the zookeeper connection
	 */
	public void closeConnection() {
		try {
			zkConnection.close();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void create(String path, byte[] data) throws KeeperException,
			InterruptedException {
		zkeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE,
				CreateMode.PERSISTENT);

	}

	@Override
	public Stat getZNodeStats(String path) throws KeeperException,
			InterruptedException {
		Stat stat = zkeeper.exists(path, true);
		if (stat != null) {
			System.out.println("Node exists and the node version is "
					+ stat.getVersion());
		} else {
			System.out.println("Node does not exists");
		}
		return stat;
	}

	@Override
	public Object getZNodeData(String path, boolean watchFlag) throws KeeperException,
			InterruptedException {
		
		try {

			Stat stat = getZNodeStats(path);
			byte[] b = null;
			
			if (stat != null) {
				if(watchFlag){
					ZKWatcher watch = new ZKWatcher();
					 b = zkeeper.getData(path, watch,null);
					 watch.await();
				}else{
					 b = zkeeper.getData(path, null,null);
				}
				/*byte[] b = zkeeper.getData(path, new Watcher() {

					public void process(WatchedEvent we) {

						if (we.getType() == Event.EventType.None) {
							switch (we.getState()) {
							case Expired:
								connectedSignal.countDown();
								break;
							}

						} else {

							try {
								byte[] bn = zkeeper.getData(path, false, null);
								String data = new String(bn, "UTF-8");
								System.out.println(data);
								connectedSignal.countDown();

							} catch (Exception ex) {
								System.out.println(ex.getMessage());
							}
						}
					}
				}, null);*/

				String data = new String(b, "UTF-8");
				System.out.println(data);
				
				return data;
			} else {
				System.out.println("Node does not exists");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sodec.embeddedZk.binuGlobinch.ZKManager#watch(java.lang.String)
	 */
	@Override
	public void observer(String repertoire, Observateur observateur) throws KeeperException, InterruptedException {

		try {

			Stat stat = getZNodeStats(repertoire);

			if (stat != null) {
				
				Watcher watcher = new Watcher() {
					
					// private CountDownLatch connectedSignal = new CountDownLatch(1);

					public void process(WatchedEvent event) {

						if (event.getType() == Event.EventType.None) {
							switch (event.getState()) {
							case Expired: // session expirée. Il faut reconnecter.
								//connectedSignal.countDown();
								break;
							default:
								break;
							}

						} else {

							try {
								byte[] bn = zkeeper.getData(repertoire, false, null);
								String data = new String(bn, "UTF-8");
								System.out.println(data);
								//connectedSignal.countDown();
								
								// invocation de l'observateur
								observateur.traiter(repertoire, data);

							} catch (Exception ex) {
								System.out.println(ex.getMessage());
							}
						}
					}
				};
				 
				/*byte [] b = */ zkeeper.getData(repertoire, watcher, null);
				 
				 
			} else {
				System.out.println("Node does not exists");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void update(String path, byte[] data) throws KeeperException,
			InterruptedException {
		int version = zkeeper.exists(path, true).getVersion();
		zkeeper.setData(path, data, version);

	}

	@Override
	public List<String> getZNodeChildren(String path) throws KeeperException,
			InterruptedException {
		Stat stat = getZNodeStats(path);
		List<String> children  = null;

		if (stat != null) {
			children = zkeeper.getChildren(path, false);
			for (int i = 0; i < children.size(); i++)
				System.out.println(children.get(i)); 
			
		} else {
			System.out.println("Node does not exists");
		}
		return children;
	}

	@Override
	public void delete(String path) throws KeeperException,
			InterruptedException {
		Stat stat = zkeeper.exists(path, true);
		
		// si le node exists
		if (stat != null) {
			int version = stat.getVersion();
			zkeeper.delete(path, version);
		}
	}

	/* (non-Javadoc)
	 * @see com.sodec.embeddedZk.binuGlobinch.ZKManager#connect(java.lang.String)
	 */
	@Override
	public void connect(String hostPort) throws KeeperException, InterruptedException {
		try {
			zkConnection = new ZKConnection();
			zkeeper = zkConnection.connect(hostPort);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}