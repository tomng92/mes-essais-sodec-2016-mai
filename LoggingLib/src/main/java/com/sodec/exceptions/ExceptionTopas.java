/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.exceptions;

import java.util.Map;

/**
 * @author tnguyen 2016-06-29
 * @version 1.0
 *
 */
public interface ExceptionTopas {
	Throwable getCause();
	CodeErreurTopas getCodeErreur();
	String getMessage();
	String getContexte();
	int getSeverite();
	
	String getParam(String cle);
	Map<String, String> getParams();
	ExceptionTopas setParam(String cle, String valeur);
}
