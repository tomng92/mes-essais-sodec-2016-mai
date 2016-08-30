/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.utilitaire.journalisation;

/**
 * @author tnguyen 25 août 2016
 * @version 1.0
 *
 */
public class EntreeJournalisation {
	
	/**
	 * Identification de la donnée de contexte concernée par cette entrée
	 *  - ID type d’entrée
	 *  - ID acteur
	 *  - ID service / composante
	 *  - ID nœud
	 */
	private String type;
	
	/**
	 * Détermine pour quelle valeur cette entrée est définie. 
	 * (Valeur d’un ID du type énoncé dans le champ Type de spécification).
	 */
	private String valeur;
	
	private boolean journaliser;
	private boolean alerter;
	
//	public static String TRAITEMENT_NORMAL = "NORMAL";
//	public static String TRAITEMENT_MASQUAGE = "MASQUAGE"; // masque à appliquer sur le corps
//	public static String TRAITEMENT_ANONYMISATION = "ANONYMISATION" // une méthode d’anonymisation doit être appliquée sur le corps

	private boolean obfusquer;
	private String obfuscateur;
	
	
	public static final EntreeJournalisation ENTREE_DEBUG = new EntreeJournalisation("DEBUG", true, false, false, null);
	public static final EntreeJournalisation ENTREE_EXCEPTION = new EntreeJournalisation("EXCEPTION", true, false, false, null);
	public static final EntreeJournalisation ENTREE_ALERT = new EntreeJournalisation("ALERT", true, true, false, null);
	public static final EntreeJournalisation ENTREE_MASQUE = new EntreeJournalisation("MASQUE", true, true, true, "masque");
	public static final EntreeJournalisation ENTREE_AUDIT = new EntreeJournalisation("AUDIT", true, true, false, null);
	
	


	/**
	 * 
	 */
	public EntreeJournalisation(String type, boolean journaliser, boolean alerter, boolean obfusquer, String obfuscateur) {
		// TODO Constructeur de substitut auto-générée
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getValeur() {
		return valeur;
	}


	public void setValeur(String valeur) {
		this.valeur = valeur;
	}


	public boolean isJournaliser() {
		return journaliser;
	}


	public void setJournaliser(boolean journaliser) {
		this.journaliser = journaliser;
	}


	public boolean isAlerter() {
		return alerter;
	}


	public void setAlerter(boolean alerter) {
		this.alerter = alerter;
	}


	public boolean isObfusquer() {
		return obfusquer;
	}


	public void setObfusquer(boolean obfusquer) {
		this.obfusquer = obfusquer;
	}


	public String getObfuscateur() {
		return obfuscateur;
	}


	public void setObfuscateur(String obfuscateur) {
		this.obfuscateur = obfuscateur;
	}

}
