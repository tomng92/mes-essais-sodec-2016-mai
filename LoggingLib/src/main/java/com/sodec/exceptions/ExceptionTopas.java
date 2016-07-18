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
 * Il y a 2 exceptions dérivées de ExceptionTopas:
 *   - ExceptionAffaireTopas. Vous pouvez sous-classer ou utiliser cette exception telle quelle.
 *       Vous pouvez utiliser cette classe ou un sous-classe dans votre interface contract 
 *       (i.e. l'interface de votre composant).  
 *       public class  
 *   - ExceptionTechniqueTopas
 *  
 * Question:
 * ==========
 * Qu'est ce que la methode émettrice doit faire quand une condition d'erreur survient?
 *   - Si c'est une erreur d'affaire : 
 *       - émettre l'exception contractuelle 
 *       - wrapper par une exception technique  
 *  
 *  
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
