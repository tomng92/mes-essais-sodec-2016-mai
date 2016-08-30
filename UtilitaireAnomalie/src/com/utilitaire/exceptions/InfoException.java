/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.utilitaire.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Voir http://tutorials.jenkov.com/exception-handling-strategies/template-exception.html.
 * 
 * @author tnguyen 2016-06-21
 * @version 1.0
 *
 */
public class InfoException {
	//protected Throwable cause = null;
	protected int typeErreur = -1;
	protected int severite = -1;
	protected String idErreur = null;
	protected String idContexte = null;

	
	public InfoException(int typeErreur, int severite, String idErreur, String idContexte) {
		this.typeErreur = typeErreur;
		this.severite = severite;
		this.idErreur = idErreur;
		this.idContexte = idContexte;
		
	}

	protected String userErrorDescription = null;
	protected String errorDescription = null;
	//protected String errorCorrection = null;

	protected Map<String, Object> parameters = new HashMap<String, Object>();
	
	  @Override
	  public String toString() {
	     return "InfoException " + new ToStringBuilder(this, ToStringStyle.JSON_STYLE).
			   append("idErreur", this.idErreur).
			   append("idContexte", this.idContexte).
			   append("severite", this.severite).
			   append("errorDescription", this.errorDescription).
			   toString();
	  }



}
