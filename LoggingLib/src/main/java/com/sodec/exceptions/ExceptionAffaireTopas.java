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
public class ExceptionAffaireTopas extends RuntimeException implements ExceptionTopas {

	
	private CodeErreurTopas codeErreur;
	
	/* (non-Javadoc)
	 * @see com.sodec.exceptions.ExceptionTopas#getErrorCode()
	 */
	@Override
	public CodeErreurTopas getCodeErreur() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.ExceptionTopas#getContexte()
	 */
	@Override
	public String getContexte() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.ExceptionTopas#getSeverite()
	 */
	@Override
	public int getSeverite() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.ExceptionTopas#getParam(java.lang.String)
	 */
	@Override
	public String getParam(String cle) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.ExceptionTopas#getParams()
	 */
	@Override
	public Map<String, String> getParams() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.ExceptionTopas#setParam(java.lang.String, java.lang.String)
	 */
	@Override
	public ExceptionTopas setParam(String cle, String valeur) {
		return null;
	}

}
