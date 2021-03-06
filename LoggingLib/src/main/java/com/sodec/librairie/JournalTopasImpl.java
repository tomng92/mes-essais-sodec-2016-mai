package com.sodec.librairie;


import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Hashtable;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.InjectionPoint;

import org.jboss.weld.exceptions.UnsupportedOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.Marker;

import com.sodec.annotations.FileInfo;

/**
 * Classe de journalisation
 * @author tnguyen
 *
 */
public class JournalTopasImpl implements JournalTopas {
	
	private Logger logger;
	private Map<Object, Object> contexte;
	
	/**
	 * Constructeur.
	 * @param point
	 */
	public JournalTopasImpl(InjectionPoint point) {
		Class<?> clazz = point.getMember().getDeclaringClass();
		logger = LoggerFactory.getLogger(clazz);
		contexte = new Hashtable<Object, Object>();
		
		// Voir https://martinsdeveloperworld.wordpress.com/2014/02/23/injecting-configuration-values-using-cdis-injectionpoint/.
		Annotated annotated = point.getAnnotated();
		JournalisationInfo jinfo = annotated.getAnnotation(JournalisationInfo.class);
		System.out.println("jinfo. domaine = " + jinfo.domaine());
		
		//readAnnotationOn(clazz);
	}
	

	
	/**
	 * Ajouter une valeur dans le contexte.
	 * Quand le journal est imprimé, si l'objet est un JournalRender, la fonction render() sera utilisée, sinon c'est toString().
	 * @param ctxId
	 * @param key
	 * @param value
	 */
	@Override
	public void ajouterElementContexte(String key, Object value) {
		this.contexte.put(key, value);
	}
	
	@Override
	public void supprimerElementContexte(String key) {
		this.contexte.remove(key);
	}
	
	@Override
	public void effacerContexte() {
		this.contexte.clear();
	}
	
	/**
	 * Injecte le contexte dans le MDC.
	 * @param renderer
	 */	
	void injecteContexte(ContexteRenderer renderer) {
		Map<String, String> map = renderer.getRenderMap();
		for (String key: map.keySet()) {
			MDC.put(key, map.get(key));
		}
	}
	
	/* (non-Javadoc)
	 * @see com.sodec.librairie.JournalTopas#ecrire(com.sodec.librairie.TypeEntreeJournal, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void ecrire(TypeEntreeJournal typeEntree, String format, Object... objects) {
		// TODO Méthode de substitut auto-générée
		
	}	

	static void readAnnotationOn(AnnotatedElement element) {
		try {
			System.out.println("\n Finding annotations on " + element.getClass().getName());
			System.out.println("\n Finding annotations on " + element.toString());
			Annotation[] annotations = element.getAnnotations();
			for (Annotation annotation : annotations) {
				if (annotation instanceof FileInfo) {
					FileInfo fileInfo = (FileInfo) annotation;
					System.out.println("Author :" + fileInfo.author());
					System.out.println("Version :" + fileInfo.version());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * ==========================
	 *  Méthodes de slf4j.Logger
	 * ==========================
	 */

	public void debug(String arg0) {
		logger.debug(arg0);
	}
	
	public void error(String arg0) {
		logger.error(arg0);
	}

	public void info(String arg0) {
		logger.info(arg0);
	}

	private void throwNotImplemented() {
		throw new UnsupportedOperationException();
	}


	public void debug(String arg0, Object arg1) {
		throwNotImplemented();
		
	}

	public void debug(String arg0, Object... arg1) {
		throwNotImplemented();
		
	}

	public void debug(String arg0, Throwable arg1) {
		throwNotImplemented();
		
	}

	public void debug(Marker arg0, String arg1) {
		throwNotImplemented();
		
	}

	public void debug(String arg0, Object arg1, Object arg2) {
		throwNotImplemented();
		
	}

	public void debug(Marker arg0, String arg1, Object arg2) {
		throwNotImplemented();
		
	}

	public void debug(Marker arg0, String arg1, Object... arg2) {
		throwNotImplemented();
		
	}

	public void debug(Marker arg0, String arg1, Throwable arg2) {
		throwNotImplemented();
		
	}

	public void debug(Marker arg0, String arg1, Object arg2, Object arg3) {
		throwNotImplemented();
		
	}

//	public void error(String arg0) {
//		throwNotImplemented();
//		
//	}

	public void error(String arg0, Object arg1) {
		throwNotImplemented();
		
	}

	public void error(String arg0, Object... arg1) {
		throwNotImplemented();
		
	}

	public void error(String arg0, Throwable arg1) {
		throwNotImplemented();
		
	}

	public void error(Marker arg0, String arg1) {
		throwNotImplemented();
		
	}

	public void error(String arg0, Object arg1, Object arg2) {
		throwNotImplemented();
		
	}

	public void error(Marker arg0, String arg1, Object arg2) {
		throwNotImplemented();
		
	}

	public void error(Marker arg0, String arg1, Object... arg2) {
		throwNotImplemented();
		
	}

	public void error(Marker arg0, String arg1, Throwable arg2) {
		throwNotImplemented();
		
	}

	public void error(Marker arg0, String arg1, Object arg2, Object arg3) {
		throwNotImplemented();
		
	}

	public String getName() {
		throwNotImplemented();
		return null;
	}

//	public void info(String arg0) {
//		throwNotImplemented();
//		
//	}

	public void info(String arg0, Object arg1) {
		throwNotImplemented();
		
	}

	public void info(String arg0, Object... arg1) {
		throwNotImplemented();
		
	}

	public void info(String arg0, Throwable arg1) {
		throwNotImplemented();
		
	}

	public void info(Marker arg0, String arg1) {
		throwNotImplemented();
		
	}

	public void info(String arg0, Object arg1, Object arg2) {
		throwNotImplemented();
		
	}

	public void info(Marker arg0, String arg1, Object arg2) {
		throwNotImplemented();
		
	}

	public void info(Marker arg0, String arg1, Object... arg2) {
		throwNotImplemented();
		
	}

	public void info(Marker arg0, String arg1, Throwable arg2) {
		throwNotImplemented();
		
	}

	public void info(Marker arg0, String arg1, Object arg2, Object arg3) {
		throwNotImplemented();
		
	}

	public boolean isDebugEnabled() {
		throwNotImplemented();
		return false;
	}

	public boolean isDebugEnabled(Marker arg0) {
		return logger.isDebugEnabled(arg0);
	}

	public boolean isErrorEnabled() {
		return logger.isErrorEnabled();
	}

	public boolean isErrorEnabled(Marker arg0) {
		throwNotImplemented();
		return false;
	}

	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	public boolean isInfoEnabled(Marker arg0) {
		throwNotImplemented();
		return false;
	}

	public boolean isTraceEnabled() {
		return logger.isTraceEnabled();
	}

	public boolean isTraceEnabled(Marker arg0) {
		throwNotImplemented();
		return false;
	}

	public boolean isWarnEnabled() {
		throwNotImplemented();
		return false;
	}

	public boolean isWarnEnabled(Marker arg0) {
		throwNotImplemented();
		return false;
	}

	public void trace(String arg0) {
		throwNotImplemented();
		
	}

	public void trace(String arg0, Object arg1) {
		throwNotImplemented();
		
	}

	public void trace(String arg0, Object... arg1) {
		throwNotImplemented();
		
	}

	public void trace(String arg0, Throwable arg1) {
		throwNotImplemented();
		
	}

	public void trace(Marker arg0, String arg1) {
		throwNotImplemented();
		
	}

	public void trace(String arg0, Object arg1, Object arg2) {
		throwNotImplemented();
		
	}

	public void trace(Marker arg0, String arg1, Object arg2) {
		throwNotImplemented();
		
	}

	public void trace(Marker arg0, String arg1, Object... arg2) {
		throwNotImplemented();
	}

	public void trace(Marker arg0, String arg1, Throwable arg2) {
		throwNotImplemented();		
	}

	public void trace(Marker arg0, String arg1, Object arg2, Object arg3) {
		throwNotImplemented();
	}

	public void warn(String arg0) {
		logger.warn(arg0);
	}

	public void warn(String arg0, Object arg1) {
		throwNotImplemented();
	}

	public void warn(String arg0, Object... arg1) {
		throwNotImplemented();
	}

	public void warn(String arg0, Throwable arg1) {
		throwNotImplemented();
	}

	public void warn(Marker arg0, String arg1) {
		throwNotImplemented();
	}

	public void warn(String arg0, Object arg1, Object arg2) {
		throwNotImplemented();
	}

	public void warn(Marker arg0, String arg1, Object arg2) {
		throwNotImplemented();
	}

	public void warn(Marker arg0, String arg1, Object... arg2) {
		throwNotImplemented();
	}

	public void warn(Marker arg0, String arg1, Throwable arg2) {
		throwNotImplemented();
	}

	public void warn(Marker arg0, String arg1, Object arg2, Object arg3) {
		throwNotImplemented();
	}

}
