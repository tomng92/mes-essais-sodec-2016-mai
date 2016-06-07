/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package gouv.sodec.topas.journalisation.TEMP;

import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

/**
 * @author tnguyen 2016-06-03
 * @version 1.0
 *
 */
public class TopasLayout extends Layout {

	/* (non-Javadoc)
	 * @see org.apache.log4j.spi.OptionHandler#activateOptions()
	 */
	@Override
	public void activateOptions() {
		// TODO Méthode de substitut auto-générée
		
	}

	/* (non-Javadoc)
	 * @see org.apache.log4j.Layout#format(org.apache.log4j.spi.LoggingEvent)
	 */
	@Override
	public String format(LoggingEvent arg0) {
		// TODO Méthode de substitut auto-générée
		return null;
	}

	/* (non-Javadoc)
	 * @see org.apache.log4j.Layout#ignoresThrowable()
	 */
	@Override
	public boolean ignoresThrowable() {
		// TODO Méthode de substitut auto-générée
		return false;
	}

}
