/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.sodec.exceptions;

/**
 * CodeErreur est la liste des erreurs de Topas.
 * Les erreurs 
 * @author tnguyen 2016-06-29
 * @version 1.0
 *
 */
public enum CodeErreurNSE implements CodeErreurTopas {
	
	ERREUR_USAGER_NON_TROUVE(1, "erreur-usager-non-trouve"),
	ERREUR_OPERATION_NON_VALIDE(2, "erreur-operation-non-valide");
	
	private final int code; // code de l"erreur
	private final String cle; // clé dans resource bundle, ex "erreur-usager-non-trouve". La clé utilise le préfixe, "NSE-erreur-usager-non-trouve"
	
	private CodeErreurNSE(int code, String cle)  {
		this.code = code;
		this.cle = cle;
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.CodeErreurTopas#getCode()
	 */
	@Override
	public int getCode() {
		return code;
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.CodeErreurTopas#getCodePourAffichage()
	 */
	@Override
	public String getCodeAffichage() {
		return getPrefix() + "-" + getCode();
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.CodeErreurTopas#getCleMsg()
	 */
	@Override
	public String getCleMsg() {
		return getPrefix() + "-" + this.cle;
	}

	/* (non-Javadoc)
	 * @see com.sodec.exceptions.CodeErreurTopas#getPrefix()
	 */
	@Override
	public String getPrefix() {
		return "NSE";
	}
	
	public String getCle() {
		return cle;
	}
	
	@Override
	public String toString() {
		return "CodeErreurNSE[code=" + this.code + ", cleMsg=" + getCleMsg() + "]"; 
	}
}
