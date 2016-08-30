/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.utilitaire.exceptions.main;

import com.utilitaire.exceptions.CodeErreurTopas;

/**
 * Contient le mapping de CodeErreur.
 * Par exemple , on veut mapper le code d'erreur A1234 vers B4567
 * @author tnguyen 22 août 2016
 * @version 1.0
 *
 */
public class CodeErreurInfoTraduction {

	CodeErreurTopas sourceErreur;
	public CodeErreurTopas destinationErreur;
	public boolean arreterSvc;
	public boolean leverException; // lever une exception sur destinationErreur

	public CodeErreurInfoTraduction(CodeErreurTopas sourceErreur, CodeErreurTopas destinationErreur, boolean arreterSvc, boolean leverExc) {
		this.sourceErreur = sourceErreur;
		this.destinationErreur = destinationErreur;
		this.arreterSvc = arreterSvc;
		this.leverException = leverExc;
	}

}
