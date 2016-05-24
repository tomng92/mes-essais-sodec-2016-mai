package com.sodec.main;

import java.util.List;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.environment.se.bindings.Parameters;
import org.jboss.weld.environment.se.events.ContainerInitialized;
import org.slf4j.Logger;

import com.sodec.librairie.JournalisationDomaine;
import com.sodec.librairie.JournalisationInfo;

/**
 * http://coders-kitchen.com/2014/01/15/using-cdi-standalone/
 * 
 * @author tnguyen; 17 Mai 2016
 *
 */
public class Main {

	@Inject
	@JournalisationInfo(domaine = JournalisationDomaine.SECURE)
	Logger journal;

	public static void main(String[] args) {

		Weld weld = new Weld();

		/**WeldContainer container = */
		weld.initialize();
			
		// Instantiation de notre classe.
		BeanManager bm = CDI.current().getBeanManager();
		
		Bean<?> bean = bm.getBeans(Main.class).iterator().next();
		CreationalContext<?> ctx = bm.createCreationalContext(bean);
		Main main = (Main) bm.getReference(bean, Main.class, ctx);
		main.journal.warn("Bonjour! J'existe maintenant!!");
		
		weld.shutdown();
	}

	public void bootListener(@Observes ContainerInitialized event, @Parameters List<String> cmdLineArgs) {
		if (cmdLineArgs.isEmpty()) {
			journal.error("ContainerInitialized !! I am invoked with no args!!!");
			journal.warn("Type d'opération inconnu: " + "listePersonneParNom");
		} else {
			journal.error("ContainerInitialized !! With args!!!" + cmdLineArgs.get(0));
		}
	}
}
