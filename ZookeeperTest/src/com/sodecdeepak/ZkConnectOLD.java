/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodecdeepak;

import java.util.Arrays;

/**
 * From http://stackoverflow.com/questions/33524537/good-zookeeper-tutorial-with-java-client
 * 
 * @author tnguyen 2016-08-29
 * @version 1.0
 *
 */


import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.KeeperException.Code;

public class ZkConnectOLD {
    private ZooKeeper zk;
    private CountDownLatch connSignal = new CountDownLatch(1);

    //host should be 127.0.0.1:3000,127.0.0.1:3001,127.0.0.1:3002
    public ZooKeeper connect(String host) throws Exception {
    	
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
    
    /**
     * 
     */
//    private AsyncCallback.StatCallback callback = new AsyncCallback.StatCallback() {
//		
//		@Override
//		public void processResult(int rc, String path, Object ctx, Stat stat) {
//	        boolean exists, dead;
//	        switch (rc) {
//	        case Code.Ok:
//	            exists = true;
//	            break;
//	        case Code.NoNode:
//	            exists = false;
//	            break;
//	        case Code.SessionExpired:
//	        case Code.NoAuth:
//	            dead = true;
//	            listener.closing(rc);
//	            return;
//	        default:
//	            // Retry errors
//	            zk.exists(path, true, this, null);
//	            return;
//	        }
//
//	        byte b[] = null;
//	        if (exists) {
//	            try {
//	                b = zk.getData(znode, false, null);
//	            } catch (KeeperException e) {
//	                // We don't need to worry about recovering now. The watch
//	                // callbacks will kick off any exception handling
//	                e.printStackTrace();
//	            } catch (InterruptedException e) {
//	                return;
//	            }
//	        }
//	        if ((b == null && b != prevData)
//	                || (b != null && !Arrays.equals(prevData, b))) {
//	            listener.exists(b);
//	            prevData = b;
//	        }
//		}
//	};
	
	private Watcher watcher = new Watcher() {

		@Override
		public void process(WatchedEvent event) {
			EventType type = event.getType();
			
			if (type == EventType.NodeDataChanged) {
					try {
						byte[] data =  zk.getData(event.getPath(), this, null);
						doPrint("Received data : " + new String(data));
					} catch (KeeperException | InterruptedException e) {
						// TODO Bloque 'catch' auto-généré
						e.printStackTrace();
					}
			}
			
		}
		
	};

    public void close() throws InterruptedException {
        zk.close();
    }

    public void createNode(String path, byte[] data) throws Exception
    {
        zk.create(path, data, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public void updateNode(String path, byte[] data) throws Exception
    {
        zk.setData(path, data, zk.exists(path, true).getVersion());
    }

    public void deleteNode(String path) throws Exception
    {
        zk.delete(path,  zk.exists(path, true).getVersion());
    }
    private void doPrint(String str) {
    	System.out.println(str);
    }


    /**
     * srv-bpm-dev:2181  /TestExecutor 
     * @param args
     * @throws Exception
     */
    public static void main (String args[]) throws Exception
    {
        ZkConnectOLD connector = new ZkConnectOLD();
        String host = args[0];
        String path = args[1];
        ZooKeeper zk = connector.connect(host); // "54.169.132.0,52.74.51.0");
        
        
        connector.doPrint("Creating new node " + path + " on " + host); 
        connector.createNode(path, new Date().toString().getBytes());
        
        
        /**
         * Chercher enfants
         */
        List<String> zNodes = zk.getChildren("/", true);
               
        for (String zNode: zNodes)
        {
           System.out.println("ChildrenNode " + zNode);   
        }
        
        /**
         * Chercher data
         */
        byte[] data = zk.getData(path, true, zk.exists(path, true));
        System.out.println("GetData before setting: " + new String(data, "UTF-8"));
        System.out.println("GetData after setting");
        
        
        /**
         * Modifier data
         */
        connector.updateNode(path, "the Modified data".getBytes());
        data = zk.getData(path, true, zk.exists(path, true));
        System.out.println("Data : " + new String(data));
        
        /**
         * Surveiller node
         */
        connector.zk.exists(path, connector.watcher);
        
        //connector.zk.
        //data = zk.getData(path, true, zk.exists(path, true));
        System.out.println("Data : " + new String(data));
        
        
        
 
        /**
         * Supprimer node
         */
//        System.out.println("\n-----Deleting node " + newNode);
//        connector.deleteNode(newNode);
    }

}