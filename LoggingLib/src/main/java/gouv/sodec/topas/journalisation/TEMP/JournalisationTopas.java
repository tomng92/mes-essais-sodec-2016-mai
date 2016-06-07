/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package gouv.sodec.topas.journalisation.TEMP;

import org.slf4j.Logger;

public interface JournalisationTopas {

	/**
	 * Ajouter un contexte de traitement au MDC.
	 * Les noms de propriété MDC seont composés du id du contexte traitement et le nom de la propriété.
	 * Par exemple, la propriété MDC sera "NSE-operation" si le contexte a pour id "NSE",
	 * et que la propriété du contexte est "operation".
	 * @param ctx
	 */
	public void ajoutContexte(ContexteTraitement ctx);
	
	/**
	 * Retourner les contexte avec le id donné.
	 * @param idCtx
	 * @return
	 */
	public ContexteTraitement getContexte(String idCtx);
	
	/**
	 * Enlever le contexte du MDC.
	 * @param idCtx
	 */
	public void clearContexte(String idCtx);

}
