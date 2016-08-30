/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.utilitaire.exceptions.main;

import java.nio.charset.CoderMalfunctionError;

import com.utilitaire.exceptions.CodeErreurTopas;
import com.utilitaire.exceptions.ExceptionTopasAbstrait;

/**
 * @author tnguyen 22 août 2016
 * @version 1.0
 *
 */
public class UtilitaireAnomalieMain {

	/**
	 * 
	 */
	public UtilitaireAnomalieMain() {

		SvcA svc = new SvcA();
		
		try {
			CodeErreurTopas codeErr = svc.faireQuelqueChose();
			
			UtilitaireAnomalie.traiterCodeErreur(codeErr);
		} catch (ExceptionTopasAbstrait ex) {
			
		}
	}

}
