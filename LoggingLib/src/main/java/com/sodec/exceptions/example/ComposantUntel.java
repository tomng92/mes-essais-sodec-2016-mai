/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.exceptions.example;

/**
 * Interface du composant.
 * @author tnguyen 2016-07-06
 */
public interface ComposantUntel {
	
	/**
	 * 
	 * @param nomFichier
	 * @param usager Id de usager
	 * @return contenu du fichier.
	 */	
	String lireFichier(String nomFichier, String user) throws ExceptionUntel;
	
	int genererNombreAleatoire(int min, int max);

}
