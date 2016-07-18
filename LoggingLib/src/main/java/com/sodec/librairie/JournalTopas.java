/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.librairie;

/**
 * Interface de journalisation Topas.
 * @author tnguyen 2016-07-12
 */
public interface JournalTopas {
	
	public void ajouterElementContexte(String cle, Object valeur);
	
	/**
	 * Supprimer l'élément du contexte.
	 * @param cle
	 */
	public void supprimerElementContexte(String cle);
	
	/**
	 * Effacer tous les éléments du contexte.
	 */
	public void effacerContexte();
	
	/**
	 * Écrire une ligne de journal.
	 * @param typeEntree Détermine le mode de journalisation. Les TypeEntree sont donnée au démarrage de l'application.
	 * @param format Format du message du journl. Suit slf4j.
	 * @param params Paramètres de l'entrée de journal.
	 */
	public void ecrire(TypeEntreeJournal typeEntree, String format, Object ... params);
	
}
