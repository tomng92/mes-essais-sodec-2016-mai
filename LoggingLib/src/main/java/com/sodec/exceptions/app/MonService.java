/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.exceptions.app;

import com.sodec.exceptions.ExceptionTopas;

/**
 * Voir article de Rich Hightower: https://dzone.com/articles/cdi-aop.
 * @author tnguyen 2016-06-21
 * @version 1.0
 *
 */
public class MonService {
	
	public void executeMonService() throws ExceptionTopas {
		ClasseA a = new ClasseA();
		a.faitA(null);
	}

}
