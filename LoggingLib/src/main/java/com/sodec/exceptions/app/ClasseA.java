/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.exceptions.app;

import com.sodec.exceptions.ExceptionTopasAbstrait;

/**
 * @author tnguyen 2016-06-21
 * @version 1.0
 *
 */
public class ClasseA {
	
	public void faitA(String nomFichier) throws ExceptionTopasAbstrait {
		
		ClasseB b = new ClasseB();
		
		/**
		 * L'exception (potentiellement produit par b.faitB())
		 * se propage sans devoir utiliser le try catch.
		 * 
		 */
		
		b.faitB(nomFichier);
	}
	
	

}
