/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.utilitaire.exceptions.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.utilitaire.exceptions.CodeErreurNSE;
import com.utilitaire.exceptions.CodeErreurTopas;
import com.utilitaire.exceptions.ExceptionTechniqueTopas;

/**
 * @author tnguyen 22 août 2016
 * @version 1.0
 *
 */
public class UtilitaireAnomalie {

	/**
	 * Cette liste est provient de la configuration.
	 */
	private static Map<CodeErreurTopas, CodeErreurInfoTraduction> traductions;

	private ArrayList<CodeErreurTopas> erreurs = new ArrayList<>();

	static {
		traductions = new HashMap<>();

		// Ligne de configuration
		// <traductions-code-erreur>
		// A2, B2, false,
		traductions.put(CodeErreurNSE.ERREUR_USAGER_NON_TROUVE,
				new CodeErreurInfoTraduction(CodeErreurNSE.ERREUR_USAGER_NON_TROUVE, null, false, false));
		traductions.put(CodeErreurNSE.ERREUR_OPERATION_NON_VALIDE, new CodeErreurInfoTraduction(
				CodeErreurNSE.ERREUR_OPERATION_NON_VALIDE, CodeErreurNSE.ERREUR_OPERATION_NON_VALIDE, false, true));
	}

	/**
	 * 
	 */
	public static void traiterCodeErreur(CodeErreurTopas codeErr) throws ExceptionTechniqueTopas {

		doJournalise("Traitement du code erreur " + codeErr.toString());

		// si non trouvé: lever exception telle quelle
		CodeErreurInfoTraduction ceti = traductions.get(codeErr);

		if (ceti == null) {
			throw new ExceptionTechniqueTopas(codeErr, "bdon", "bidon", null);
		} else if (ceti.destinationErreur == null) {
			doJournalise("Annulation du code erreur");
			return;
		} else {
			ExceptionTechniqueTopas newEx;

			if (!codeErr.equals(ceti.destinationErreur)) {
				doJournalise("conversion de codeErr à nouveau");

				
				// convertir le ceti.destination en exc. contractuelle
				newEx = new ExceptionTechniqueTopas(ceti.destinationErreur, codeErr, "paramter supplemetaires", null);

				// tester si on doit
			} else {
				newEx = new ExceptionTechniqueTopas(codeErr, null, "paramter supplemetaires", null);

			}

			if (ceti.arreterSvc) {
				// invoque arreter service
			}

			// si lever exception
			if (false) {
				throw newEx;
			} else {
				// enregistre le code err
				erreurs.add(codeErr);
			}
		}
	}

	/**
	 * @param string
	 */
	private static void doJournalise(String string) {
		// TODO Méthode de substitut auto-générée
		
	}

	/**
	 * @param codeErr
	 */
	private static void doJournalise(CodeErreurTopas codeErr) {
		// TODO Méthode de substitut auto-générée
		
	}

	List<> getCodeErreurs() {
		return erreurs;
	}

}
