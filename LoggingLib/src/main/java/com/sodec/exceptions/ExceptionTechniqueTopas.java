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
 * Exception de type runtime qui nveloppe une exception technique.
 * Par exemple, erreur de codage, problème de resource manquant, de config, ou RuntimeExceptions.
 *  
 * @author tnguyen 2016-06-29
 *
 */
public class ExceptionTechniqueTopas extends RuntimeException implements ExceptionTopas {

	
	private static final long serialVersionUID = 1L;
	
	private CodeErreurTopas codeErreur;

	public ExceptionTechniqueTopas(CodeErreurTopas codeErreur, String message, Throwable cause) {
		super(message, cause);
		this.codeErreur = codeErreur;
		this.params = new HashMap<String, String>();
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.ExceptionTopas#getErrorCode()
	 */
	@Override
	public CodeErreurTopas getCodeErreur() {
		return codeErreur;
	}


	/* (non-Javadoc)
	 * @see com.sodec.exceptions.ExceptionTopas#getParam(java.lang.String)
	 */
	@Override
	public String getValeurCtx(String cle) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.ExceptionTopas#getParams()
	 */
	@Override
	public Map<String, String> getCtx() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.ExceptionTopas#setParam(java.lang.String, java.lang.String)
	 */
	@Override
	public ExceptionTopas setValeurCtx(String cle, String valeur) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.ExceptionTopas#getException()
	 */
	@Override
	public Exception getException() {
		return (Exception) this;
	}

}
