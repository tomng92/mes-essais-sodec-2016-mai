/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.binu;

/*
 * @(#)ZKManager.java
 * @author Binu George
 * Globinch.com
 * copyright http://www.java.globinch.com. All rights reserved.
 */
//package com.globinch.zoo.client;

import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.AsyncCallback.DataCallback;
import org.apache.zookeeper.data.Stat;

/**
 * ZKManager Interface. Defines the methods to manipulate znodes
 * 
 * @author Binu George
 * @since 2016
 * @version 1.0
 * http://www.java.globinch.com. All rights reserved
 */
public interface ZKManager {
	/**
	 * Create a Znode and save some data
	 * 
	 * @param path
	 * @param data
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	public void create(String path, byte[] data) throws KeeperException,
			InterruptedException;

	/**
	 * Get the ZNode Stats
	 * 
	 * @param path
	 * @return Stat
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	public Stat getZNodeStats(String path) throws KeeperException,
			InterruptedException;

	/**
	 * Get ZNode Data
	 * 
	 * @param path
	 * @param boolean watchFlag
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	public Object getZNodeData(String path,boolean watchFlag) throws KeeperException,
			InterruptedException;

	/**
	 * Update the ZNode Data
	 * 
	 * @param path
	 * @param data
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	public void update(String path, byte[] data) throws KeeperException,
			InterruptedException;

	/**
	 *  <========================================
	 * Watch the ZNode Data
	 *    Implemented by Thanh!!!!! 29 Aout 2016
	 *  <========================================
	 * 
	 * @param path
	 * @param data
	 * @throws KeeperException
	 * @throws InterruptedException
	 * @return retourne le data du node
	 */
	public void watchForChanges(String path, DataCallback cb) throws KeeperException,
			InterruptedException;

	/**
	 * Get ZNode children
	 * 
	 * @param path
	 * @throws KeeperException
	 * @throws InterruptedException
	 * return List<String>
	 */
	public List<String> getZNodeChildren(String path) throws KeeperException,
			InterruptedException;

	/**
	 * Delete the znode
	 * 
	 * @param path
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	public void delete(String path) throws KeeperException,
			InterruptedException;
}