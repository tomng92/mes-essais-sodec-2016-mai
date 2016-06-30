/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.exceptions;

/**
 * @author tnguyen 2016-06-30
 * @version 1.0
 *
 */
public class Mainx {
	
	public static void main(String[] args) {
		try {
			callA();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private static void callA() throws Exception {
	
		try {
			callB();
		} catch (Exception exOrig) {
			throw new Exception("Exception dans CallA", exOrig);
		}
	}

	/**
	 * Ne fait rien
	 */
	private static void callB() throws Exception {
		throw new Exception("Exception dans CallB");
	}
}
