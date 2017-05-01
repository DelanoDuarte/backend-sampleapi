/**
 * 
 */
package br.com.sampleapi.repository;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.sampleapi.domain.Evento;

/**
 * @author Delano Jr
 *
 */

@RequestScoped
public class EventoRepository implements Serializable, IEventoRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	@Override
	public void save(Evento evento) throws Exception {
		entityManager.merge(evento);
	}

	@Override
	public Evento find(Long id) throws Exception {
		return entityManager.find(Evento.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> findAll() throws Exception {
		return entityManager.createNamedQuery("Evento.findAll").getResultList();
	}

	@Override
	public void delete(Long id) throws Exception {
		Evento evento = find(id);
		entityManager.remove(evento);
	}

}
