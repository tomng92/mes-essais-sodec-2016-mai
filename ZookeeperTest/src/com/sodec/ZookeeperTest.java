/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec;

import java.io.IOException;
import java.util.Arrays;

import org.apache.zookeeper.AsyncCallback.StatCallback;
import org.apache.zookeeper.KeeperException.Code;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @author tnguyen 2016-08-30
 * @version 1.0
 *
 */
public class ZookeeperTest implements Watcher, StatCallback, Runnable {
	
	ZooKeeper zk;
	String znodePath;
    byte prevData[] = null;
	
	public static void main(String[] args)   {
		try {
			ZookeeperTest soz = new ZookeeperTest();
			String hostPort = args[0];
			soz.zk = new ZooKeeper(hostPort, 3000, null);
			
			soz.znodePath = args[1];
			soz.zk.exists(soz.znodePath, true, soz, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public ZookeeperTest() {
		// TODO Constructeur de substitut auto-générée
	}

	/* (non-Javadoc)
	 * @see org.apache.zookeeper.Watcher#process(org.apache.zookeeper.WatchedEvent)
	 */
	@Override
	public void process(WatchedEvent event) {
		// TODO Méthode de substitut auto-générée
		String path = event.getPath();
		throw new RuntimeException("Pas implementé!");
		
	}

    public void closing(int rc) {
        synchronized (this) {
            notifyAll();
        }
    }
    
    private void doPrint(String str) {
    	System.out.println(znodePath + ": " + str);
    }

    /* (non-Javadoc)
	 * @see org.apache.zookeeper.AsyncCallback.StatCallback#processResult(int, java.lang.String, java.lang.Object, org.apache.zookeeper.data.Stat)
	 */
	@Override
	public void processResult(int rc, String path, Object ctx, Stat stat) {
		boolean nodeExists = true;
		
        switch (rc) {

        case Code.Ok:
        case Code.NoNode:
        	nodeExists = false;
            doPrint("Code = " + rc);
            break;
        case Code.SessionExpired:
        case Code.NoAuth:
        	nodeExists = (rc == Code.Ok);
        	doPrint("Code = " + rc + " - node exists = " + nodeExists);
            return;
        default:
            // Retry errors
            zk.exists(znodePath, true, this, null);
            return;
        }

        byte b[] = null;
        if (nodeExists) {
            try {
                b = zk.getData(path, false, null);
            } catch (KeeperException e) {
                // We don't need to worry about recovering now. The watch
                // callbacks will kick off any exception handling
                e.printStackTrace();
            } catch (InterruptedException e) {
                return;
            }
        }
        if ((b == null && b != prevData)
                || (b != null && !Arrays.equals(prevData, b))) {
            listener.exists(b);
            prevData = b;
        }
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
        try {
            synchronized (this) {
                while (true) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
        }
	}

}
