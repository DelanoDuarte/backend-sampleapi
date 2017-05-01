/**
 * 
 */
package br.com.sampleapi.jpaconfig;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Delano Jr
 *
 */
public class EntityManagerProducer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager entityManager;

	@Produces
	@ApplicationScoped
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
