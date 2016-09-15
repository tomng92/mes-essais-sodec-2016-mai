/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.embeddedZk.binuGlobinch;

/*
 * @(#)ZKManager.java
 * @author Binu George
 * Globinch.com
 * copyright http://www.java.globinch.com. All rights reserved.
 */

import java.util.List;

import org.apache.zookeeper.KeeperException;
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
	 * Connect to a zookeeper server.
	 * 
	 * @param hostport
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	public void connect(String hostport) throws KeeperException,
			InterruptedException;

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
	 * Observer un répertoire de configuration
	 * 
	 * @param path
	 * @param observateur Observateur qui sera invoqué quand le path est modifié.
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	public void observer(String path, Observateur observateur) throws KeeperException, InterruptedException;

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
	 * Supprimer le znode. Ne rien faire si znode n'existe pas. 
	 * 
	 * @param path
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	public void delete(String path) throws KeeperException,
			InterruptedException;
}