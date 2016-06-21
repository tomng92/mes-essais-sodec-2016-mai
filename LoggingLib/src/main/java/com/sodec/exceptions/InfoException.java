/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.exceptions;

import java.util.HashMap;
import java.util.Map;

/**
 * Voir http://tutorials.jenkov.com/exception-handling-strategies/template-exception.html.
 * 
 * @author tnguyen 2016-06-21
 * @version 1.0
 *
 */
public class InfoException {
	//protected Throwable cause = null;
	protected String idErreur = null;
	protected String idContexte = null;

	protected int typeErreur = -1;
	protected int severite = -1;

	protected String userErrorDescription = null;
	protected String errorDescription = null;
	protected String errorCorrection = null;

	protected Map<String, Object> parameters = new HashMap<String, Object>();

}
