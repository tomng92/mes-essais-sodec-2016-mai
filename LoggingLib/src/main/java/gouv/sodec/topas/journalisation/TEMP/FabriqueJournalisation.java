/*
 * JBoss, Home of Professional Open Source Copyright 2013, Red Hat, Inc. and/or its affiliates, and
 * individual contributors by the @authors tag. See the copyright.txt in the distribution for a full
 * listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in
 * writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package gouv.sodec.topas.journalisation.TEMP;

import com.sodec.librairie.JournalSodacces;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Singleton;

/**
 * Cette classe utilise CDI (Contexts and Dependency Injection) pour assigner
 * des ressources Java EE, tels que le contexte de persistance, dans des
 * composants logiciels JavaBeans.
 * 
 * Cette classe est 'découverte' par le scanning de Weld.
 * 
 * <p>
 * Exemple d'injection dans le champ d'un composant logiciel JavaBeans:
 * </p>
 */
@Singleton
public class FabriqueJournalisation {

//	@Produces
//	public JournalSodacces produireJournal(InjectionPoint pointInjection) {
//		return new JournalSodacces(pointInjection);
//	}
}