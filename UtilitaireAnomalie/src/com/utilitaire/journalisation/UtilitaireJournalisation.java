/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.utilitaire.journalisation;

/**
 * Utilitaire de configuration:
 *    Garde la liste des types d'entrée.
 * 
 * 
 * 
 * @author tnguyen 25 août 2016
 * @version 1.0
 *
 */
public class UtilitaireJournalisation {
	

	
	static {
		loadConfig();
	}
	
	
	/**
	 * Similaire au MDC de slf4j.
	 * Ajouter une valeur contextuelle au MDC.
	 * Notez que
	 * @param context
	 * @param value
	 */
	public static addContext(String context, String value) {
		MDC
	}
	
	public static ecrire(EntreeJournalisation entree, ) {
		
	}
	
	/**
	 * 
	 */
	public UtilitaireJournalisation() {

	}

}
