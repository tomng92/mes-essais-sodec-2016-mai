/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.librairie;

/**
 * Spécifie le mode de journalisation. Est utilisé dans l'appel de journalisation comme suit:
 *   
 *    journal.ecrire(typeEntree, "Numéro de téléphone {} invalide!", telephone.numero);
 * 
 * @author tnguyen 2016-07-12
 *
 */
public class TypeEntreeJournal {
	
	private String groupe;
	private boolean journaliser;
	private boolean alerte;
	private String masque;// nil = aucun masquage, masque = masque à appliquer, nom = méthode de masquage;
	
	public TypeEntreeJournal(String groupe, boolean journaliser, boolean alerte, String masque) {
		this.groupe = groupe;
		this.journaliser = journaliser;
		this.alerte = alerte;
		this.masque = masque;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	public boolean isJournaliser() {
		return journaliser;
	}

	public void setJournaliser(boolean journaliser) {
		this.journaliser = journaliser;
	}

	public boolean isAlerte() {
		return alerte;
	}

	public void setAlerte(boolean alerte) {
		this.alerte = alerte;
	}

	public String getMasque() {
		return masque;
	}

	public void setMasque(String masque) {
		this.masque = masque;
	}
}
