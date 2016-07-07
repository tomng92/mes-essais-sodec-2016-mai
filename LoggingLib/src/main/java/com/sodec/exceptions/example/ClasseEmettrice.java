/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.exceptions.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.sodec.exceptions.ExceptionTechniqueTopas;

/**
 * @author tnguyen 2016-07-06
 * @version 1.0
 *
 */	
public class ClasseEmettrice {


	public String lireFichier1(String nomFichier) throws ExceptionTechniqueTopas {
		try {
			return readThisFileIntoString(nomFichier);
		} catch (IOException ioex) {
			
			ExceptionTechniqueTopas tech = new ExceptionTechniqueTopas();
		}
	}
	
	/**
	 * From http://stackoverflow.com/questions/326390/how-do-i-create-a-java-string-from-the-contents-of-a-file.
	 * @param pathname
	 * @return
	 * @throws IOException
	 */
	private String readThisFileIntoString(String pathname) throws IOException {

	    File file = new File(pathname);
	    StringBuilder fileContents = new StringBuilder((int)file.length());
	    Scanner scanner = new Scanner(file);
	    String lineSeparator = System.getProperty("line.separator");

	    try {
	        while(scanner.hasNextLine()) {
	            fileContents.append(scanner.nextLine() + lineSeparator);
	        }
	        return fileContents.toString();
	    } finally {
	        scanner.close();
	    }
	}

}
