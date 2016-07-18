/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.exceptions.example;

/**
 * Exception du composant Untel.
 * @author tnguyen 2016-07-06
 */
public class ExceptionUntel extends Exception {
	
	public static final int ERR_ARGUMENT_INVALIDE = 1;
	public static final int ERR_FICHIER_NON_TROUVE = 2;
	public static final int ERR_INTERVALLE_INVALIDE = 3;
	
	

	private static final long serialVersionUID = 1L;
	
	public ExceptionUntel(int numeroErreur, String message) {
		super(message);
	}

}
