package com.sodec.librairie;

import java.util.Map;

/** 
 * Convertis le contenu de l'objet vers un Map<String, String>.
 * Ce map peut être mis dans un MDC de slf4j par exemple.
 * @author tnguyen; 
 * @version 1.0
 * 
 *
 */
public interface ContexteRenderer {
	public Map<String, String> getRenderMap();
}
