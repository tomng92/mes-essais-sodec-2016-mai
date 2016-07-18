/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.librairie;

/**
 * Classe pour gérer la configuration des TypeEntreeJournal
 * et synchroniser la mise à jour de ces objets.
 * @author tnguyen 2016-07-12
 */
public interface GestionnaireJournalTopas {
	
	/**
	 * Fonction invoquée pour mettre à jour les types d'entrée de journal.
	 */
	void majTypesEntreeJournal();
	

	/**
	 * Rechercher le type d'entrée avec son nom.
	 * @param nom Nom du type d'entrée.
	 * @return
	 */
	TypeEntreeJournal rechercheTypeEntree(String nom);

}
