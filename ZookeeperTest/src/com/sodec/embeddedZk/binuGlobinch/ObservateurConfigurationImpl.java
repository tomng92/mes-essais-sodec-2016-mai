/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.embeddedZk.binuGlobinch;

/**
 * @author tnguyen 2016-09-15
 * @version 1.0
 *
 */
public class ObservateurConfigurationImpl implements Observateur {

	/* (non-Javadoc)
	 * @see com.sodec.embeddedZk.binuGlobinch.ObservateurConfiguration#traiter(java.lang.String, java.lang.String)
	 */
	@Override
	public void traiter(String path, String valeur) {
		System.out.format("Notre path '%s' est changé à '%s'", path, valeur);
	}

}
