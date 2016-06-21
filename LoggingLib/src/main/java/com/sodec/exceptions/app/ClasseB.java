/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.exceptions.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.sodec.exceptions.ExceptionTopas;
import com.sodec.exceptions.InfoException;

/**
 * http://tutorials.jenkov.com/java-exception-handling/fail-safe-exception-handling.html
 * @author tnguyen 2016-06-21
 * @version 1.0
 *
 */
public class ClasseB {
	public void faitB(String nomFichier) throws ExceptionTopas {
		
		InputStream input = null;

		try {

			input = new FileInputStream("myFile.txt");

			// do something with the stream

		} catch (IOException e) {
			throw createExcTopas(e);
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				throw createExcTopas(e);
			}
		}
	}

	/**
	 * @param e
	 * @return
	 */
	private ExceptionTopas createExcTopas(IOException e) {
		ExceptionTopas exc = new ExceptionTopas();
		InfoException info = new InfoException();

		// enrichier info ici
		// ...
		
		exc.addInfo(info);
		
		return exc;
	}

}
