/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.exceptions.example;

/**
 * @author tnguyen 2016-07-06
 * @version 1.0
 *
 */
public class ComposantUntelImpl implements ComposantUntel {

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.example.ComposantUntel#traiterFichier(java.lang.String)
	 */
	@Override
	public String lireFichier(String nomFichier, String user) throws ExceptionUntel {
		// TODO Méthode de substitut auto-générée
		return new ClasseIntermediaire1().lir;
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.example.ComposantUntel#genererNombreAleatoire(int, int)
	 */
	@Override
	public int genererNombreAleatoire(int min, int max) {
		// TODO Méthode de substitut auto-générée
		return 0;
	}


}
