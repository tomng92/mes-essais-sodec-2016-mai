/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Classe d'exception de base de Topas.
 * Contient une liste d'exception info.
 * 
 * @author tnguyen 2016-06-21
 * @deprecated Cet exception est en fait inutilisable! Utiliser directement  les exceptions Affaire et Technique.
 * @version 1.0
 */
public class ExceptionTopasAbstrait extends Exception { 
	
	private static final long serialVersionUID = 1L;

	
	//protected Throwable cause;
	protected List<InfoException> listExceptionInfo;


	  public ExceptionTopasAbstrait(Throwable cause) {
		  this.initCause(cause);
		  listExceptionInfo = new ArrayList<InfoException>();
	  }
	  
	  public ExceptionTopasAbstrait() {
		  this(null);
	  }

	  public InfoException addInfo(InfoException info){
	    this.listExceptionInfo.add(info);
	    return info;
	  }
	  
	  

	  public InfoException addInfo(int typeErreur, int severite, String idErreur, String idContexte ){
	    InfoException info = new InfoException(typeErreur, severite, idErreur, idContexte);
	    this.listExceptionInfo.add(info);
	    return info;
	  }

	  public List<InfoException> getListExceptionInfo() {
	    return listExceptionInfo;
	  }
	  
	  @Override
	  public String toString() {
	     return "ExceptionTopas " + new ToStringBuilder(this, ToStringStyle.JSON_STYLE).
	    	       append("cause", getCause() != null ? getCause().getMessage() : "").
	    	       append("listExceptionInfo", listExceptionInfoToString()).
	    	       toString();
	  }

	/**
	 * @return
	 */
	private String listExceptionInfoToString() {
		
		if (this.listExceptionInfo.isEmpty()) {
			return "-vide-";
		}
		StringBuilder builder = new StringBuilder("[");
		
		for (InfoException info: listExceptionInfo) {
			builder.append(info.toString())
			.append(", ");
		}
		
		return builder.toString();

	}

	  
}
