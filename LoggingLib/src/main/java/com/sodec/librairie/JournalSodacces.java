package com.sodec.librairie;


import javax.enterprise.inject.spi.InjectionPoint;

import org.jboss.weld.exceptions.UnsupportedOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

public class JournalSodacces implements Logger {
	
	private Logger logger;
	
	/**
	 * Constructeur.
	 * @param point
	 */
	public JournalSodacces(InjectionPoint point) {
		Class clazz = point.getMember().getDeclaringClass();
		logger = LoggerFactory.getLogger(clazz);
	}
	
	
	public void startMonitor(String nomEvenement) {
		
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
