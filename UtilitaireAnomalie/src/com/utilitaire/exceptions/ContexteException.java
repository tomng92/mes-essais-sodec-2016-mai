/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.utilitaire.exceptions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tnguyen 2016-07-05
 * @version 1.0
 *
 */
public class ContexteException {
	private String id;
	private Map<String, String> props;
	
	public ContexteException(String id) {
		this.id = id;
		this.props = new HashMap<>();
	}
	
	public ContexteException ajout(String prop, String valeur) {
		this.props.put(prop, valeur);
		return this;
	}

	/**
	 * @param str Chaîne d'entrée
	 * @return Retourne un contexte avec un string comme "CONTEXTE('NSE')[operation='depot-document', noProjet='A7332-011']".
	 */
	public static ContexteException parse(String str) {
		return null;	
	}

}
