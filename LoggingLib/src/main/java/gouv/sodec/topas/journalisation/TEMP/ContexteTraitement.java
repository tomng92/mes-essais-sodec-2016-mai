/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package gouv.sodec.topas.journalisation.TEMP;

import java.util.Map;

/**
 * @author tnguyen 2016-06-03
 * @version 1.0
 *
 */
public class ContexteTraitement {
	
	private String id;
	private Map<String, String> props;
	
	public void ajoutProp(String prop, String valeur) {
		this.props.put(prop, valeur);
	}

	/**
	 * Retourne un ContexteTraitement avec un string comme "CONTEXTE('NSE')[operation='depot-document', noProjet='A7332-011']".
	 * @param str
	 * @return
	 */
	public static ContexteTraitement parse(String str) {
		return null;	
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
