/**
 * 
 */
package br.com.sampleapi.repository;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.sampleapi.domain.Participante;

/**
 * @author Delano Jr
 *
 */
@RequestScoped
public class ParticipanteRepository implements Serializable, IParticipanteRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	@Override
	public void save(Participante participante) throws Exception {
		try {
			entityManager.merge(participante);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.sampleapi.repository.IParticipanteRepository#find(java.lang.Long)
	 */
	@Override
	public Participante find(Long id) throws Exception {
		try {
			return entityManager.find(Participante.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.sampleapi.repository.IParticipanteRepository#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Participante> findAll() throws Exception {
		try {
			return entityManager.createNamedQuery("Participante.findAll").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.sampleapi.repository.IParticipanteRepository#delete(java.lang.
	 * Long)
	 */
	@Override
	public void delete(Long id) throws Exception {
		try {
			Participante participante = find(id);
			entityManager.remove(participante);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
