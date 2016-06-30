/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.exceptions.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.sodec.exceptions.ExceptionTopasAbstrait;

/**
 * http://tutorials.jenkov.com/java-exception-handling/fail-safe-exception-handling.html
 * @author tnguyen 2016-06-21
 * @version 1.0
 *
 */
public class ClasseB {
	public void faitB(String nomFichier) throws ExceptionTopasAbstrait {
		
		InputStream input = null;

		try {
			
			File file = new File(nomFichier);
			// do something with the stream
			if (!file.exists()) {
				ExceptionTopasAbstrait exc = new ExceptionTopasAbstrait();
				exc.addInfo(1, 1, "fichier " + nomFichier + " non existant " , "n/a");
				throw exc;
			}

			input = new FileInputStream(nomFichier);


		} catch (IOException e) {
			throw createExcTopas(e);
		} finally {
			
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					throw createExcTopas(e);
				}
			}
		}
	}

	/**
	 * @param e
	 * @return
	 */
	private ExceptionTopasAbstrait createExcTopas(IOException cause) {
		ExceptionTopasAbstrait exc = new ExceptionTopasAbstrait(cause);
		return exc;
	}

}
