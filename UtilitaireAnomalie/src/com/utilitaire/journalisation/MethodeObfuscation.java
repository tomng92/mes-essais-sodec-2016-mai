/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.utilitaire.journalisation;

/**
 * Recherches sur "java string obfuscation" ou "java string masking":
 *   - http://stackoverflow.com/questions/16384444/simple-algorithm-for-mixing-obfuscating-a-string-with-pre-defined-chars 
 *   - http://stackoverflow.com/questions/12148281/mask-string-with-characters
 *   
 * @author tnguyen 25 août 2016
 * @version 1.0
 *
 */
public abstract class MethodeObfuscation implements TopasObfuscateur {
	/**
	 * Nom utilisé dans la configuration
	 * Exemple:
	 */
	private String nom;

	private String algorithm;
	
}
