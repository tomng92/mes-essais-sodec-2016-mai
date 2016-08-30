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
 * Exception dû à des erreurs connus du l'application ou composant.
 * Par exemple, erreur de validation, paramètre d'entrée vide, etc.
 * @author tnguyen 2016-06-29
 * @version 1.0
 *
 */
public class ExceptionAffaireTopas extends Exception implements ExceptionTopas {

	private static final long serialVersionUID = 1L;
	private CodeErreurTopas codeErreur;
	private Map<String, String> ctxErr;
	
	public ExceptionAffaireTopas(CodeErreurTopas codeErreur, String message, Throwable cause) {
		super(message, cause);
		this.codeErreur = codeErreur;
		this.ctxErr = new HashMap<String, String>();
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
		return ctxErr.get(cle);
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.ExceptionTopas#getParams()
	 */
	@Override
	public Map<String, String> getCtx() {
		return ctxErr;
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.ExceptionTopas#setParam(java.lang.String, java.lang.String)
	 */
	@Override
	public ExceptionTopas setValeurCtx(String cle, String valeur) {
		this.ctxErr.put(cle, valeur);
		return this;
	}
	
	public static void main(String[] args) {
		ExceptionTopas exct = new ExceptionAffaireTopas(CodeErreurNSE.ERREUR_USAGER_NON_TROUVE, "mon exception !", null)
				.setValeurCtx("aaa", "1111")
				.setValeurCtx("bbb", "2222")
				.setValeurCtx("ccc", "3333");
		
		//exct.getException().initCause(new Exception("une exception"));
	
		exct.getException().printStackTrace();
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + this.getCodeErreur().toString() + " " + this.getCtx().toString();
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.ExceptionTopas#getException()
	 */
	@Override
	public Exception getException() {
		return (Exception) this;
	}
}
