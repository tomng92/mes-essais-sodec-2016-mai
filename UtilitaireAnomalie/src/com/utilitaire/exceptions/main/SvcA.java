/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.utilitaire.exceptions.main;

import com.utilitaire.exceptions.CodeErreurNSE;
import com.utilitaire.exceptions.CodeErreurTopas;

/**
 * @author tnguyen 22 août 2016
 * @version 1.0
 *
 */
public class SvcA {

	/**
	 * 
	 */
	public SvcA() {
		// TODO Constructeur de substitut auto-générée
	}

	public static CodeErreurTopas faireQuelqueChose() {
		return CodeErreurNSE.ERREUR_OPERATION_NON_VALIDE;
	}
}
