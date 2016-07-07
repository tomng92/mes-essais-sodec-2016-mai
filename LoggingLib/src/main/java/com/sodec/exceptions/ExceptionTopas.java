/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.exceptions;

import java.util.Map;

/**
 * Interface des exceptions Topas
 * @author tnguyen 2016-06-29
 * @version 1.0
 *
 */
public interface ExceptionTopas {
	/**
	 * Retourne L'exception chaîné, source originale de l'exception.
	 */
	Throwable getCause();
	
	/**
	 * Code erreur qui contient les erreurs prédéfinis. 
	 */
	CodeErreurTopas getCodeErreur();
	String getMessage();
	
	/**
	 * Données contextuelles de l'erreur.
	 */
	String getValeurCtx(String cle);
	Map<String, String> getCtx();
	ExceptionTopas setValeurCtx(String cle, String valeur);
	
	/**
	 * Helper pour accéder à l'exception.
	 */
	Exception getException();
}
