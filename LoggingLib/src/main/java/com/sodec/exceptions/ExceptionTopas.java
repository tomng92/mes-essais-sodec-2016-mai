/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe d'exception de base de Topas.
 * Contient une liste d'exception info.
 * 
 * @author tnguyen 2016-06-21
 * @version 1.0
 */
public class ExceptionTopas extends Exception {
	
	private static final long serialVersionUID = 1L;

	
	protected Throwable cause;
	protected List<InfoException> listExceptionInfo;


	  public ExceptionTopas(Throwable cause) {
		  this.cause = cause;
		  listExceptionInfo = new ArrayList<InfoException>();
	  }
	  
	  public ExceptionTopas() {
		  this(null);
	  }

	  public InfoException addInfo(InfoException info){
	    this.listExceptionInfo.add(info);
	    return info;
	  }

	  public InfoException addInfo(){
	    InfoException info = new InfoException();
	    this.listExceptionInfo.add(info);
	    return info;
	  }

	  public List<InfoException> getListExceptionInfo() {
	    return listExceptionInfo;
	  }

}
