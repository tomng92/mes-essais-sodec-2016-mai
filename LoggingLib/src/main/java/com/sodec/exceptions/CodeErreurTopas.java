/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.exceptions;

/**
 * @author tnguyen 2016-06-29
 * @version 1.0
 *
 */
public enum CodeErreurTopas {
	
	ERRORCODE_A("AAA", 1),
	ERRORCODE_B("BBB", 2);
	
	public int getCodeErreur() {
		return codeErreur;
	}

	public String getId() {
		return id;
	}

	private final int codeErreur;
	private final String id;
	
	CodeErreurTopas(String id, int codeErreur) {
		this.id = id;
		this.codeErreur = codeErreur;
	}

}
