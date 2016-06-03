/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package gouv.sodec.topas.journalisation;

import java.util.Iterator;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.helpers.BasicMarker;

/**
 * Marqueur étendu pour usage dans Topas. Ajoute:
 *   - sous-nom. Par exemple "NSE" est le nom, sous-nom "Spring 
 */
public class JournalisationUtils {

	public static Marker AUDIT = MarkerFactory.getMarker("AUDIT");
	public static Marker CONFIDENTIEL = MarkerFactory.getMarker("CONFIDENTIEL");
	public static Marker SECURE = MarkerFactory.getMarker("SECURE");
	public static Marker EXCEPTION = MarkerFactory.getMarker("EXCEPTION");

}
