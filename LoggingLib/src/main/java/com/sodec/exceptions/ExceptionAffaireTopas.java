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
 * Exemple d'utilisation:
 * 
 *   try {
 *     invokeFunctionX();
 *   } catch (Exception ex) {
 *      
 *   }
 * @author tnguyen 2016-06-29
 * @version 1.0
 *
 */
public class ExceptionAffaireTopas extends RuntimeException implements ExceptionTopas {

	private static final long serialVersionUID = 1L;
	private CodeErreurTopas codeErreur;
	private Map<String, String> params;
	
	public ExceptionAffaireTopas(CodeErreurTopas codeErreur, String message, Throwable cause) {
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
	public String getParam(String cle) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.ExceptionTopas#getParams()
	 */
	@Override
	public Map<String, String> getParams() {
		return params;
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.ExceptionTopas#setParam(java.lang.String, java.lang.String)
	 */
	@Override
	public ExceptionTopas setParam(String cle, String valeur) {
		this.params.put(cle, valeur);
		return this;
	}
	
	public static void main(String[] args) {
		ExceptionTopas exct = new ExceptionAffaireTopas(CodeErreurNSE.ERREUR_USAGER_NON_TROUVE, "mon exception !", null)
				.setParam("aaa", "1111")
				.setParam("bbb", "2222")
				.setParam("ccc", "3333");
		
		//exct.getException().initCause(new Exception("une exception"));
	
		exct.getException().printStackTrace();
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + this.getCodeErreur().toString() + " " + this.getParams().toString();
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.ExceptionTopas#getException()
	 */
	@Override
	public Exception getException() {
		return (Exception) this;
	}

}
