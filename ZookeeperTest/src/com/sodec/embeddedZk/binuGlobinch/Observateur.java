/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.embeddedZk.binuGlobinch;

/**
 * Interface d'observation.
 * @author tnguyen 2016-09-15
 * @version 1.0
 *
 */
public interface Observateur {
	void traiter(String path, String value);
}
