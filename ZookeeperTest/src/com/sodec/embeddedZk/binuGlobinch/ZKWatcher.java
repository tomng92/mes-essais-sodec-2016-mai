/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.embeddedZk.binuGlobinch;

/**
 * 
 */

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.AsyncCallback.StatCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;

/**
 * @author bpaikay
 *
 */
public class ZKWatcher implements Watcher, StatCallback {
	CountDownLatch latch;

	/**
	 * 
	 */
	public ZKWatcher() {
		latch = new CountDownLatch(1);
	}

	@Override
	public void processResult(int rc, String path, Object ctx, Stat stat) {
		// vide
		
	}

	@Override
	public void process(WatchedEvent event) {
		 System.out.println("Watcher fired on path: " + event.getPath() + " state: " + 
                 event.getState() + " type " + event.getType());
         latch.countDown();
	}
		
	public void await() throws InterruptedException {
         latch.await();
     }

}