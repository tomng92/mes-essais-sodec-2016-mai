/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.utilitaire.exceptions;

/**
 * CodeErreurTopas est la liste des erreurs de Topas.
 * À sous-classer (en enum) par les sous-systèmes, qui ajouteront leurs codes d'erreurs.
 * Quelques exemples, ErreurAjoutEntite, ErreurSvcEntite..
 * 
 * @author tnguyen 2016-06-29
 * @version 1.0
 *
 */
public interface CodeErreurTopas {
	
	/**
	 * @return Le code numérique de l'erreur, par ex. 1037
	 */
	public int getCode();	
	
	/**
	 * @return  Le code de l'erreur utilisable pour affichage.
	 */
	public String getCodeAffichage();
	
	/**
	 * @return La clé pour usage dans le resource bundle du message.
	 */
	public String getCleMsg();
	
	/**
	 * @return Le préfixe du système, comme "NSE". Ce préfixe sert internement à composer le code pour
	 *         affichage (ex. "NSE-1034"), et la clé de message (ex. "NSE-erreur-usager-non-trouve").
	 */
	public String getPrefix();
	
}
