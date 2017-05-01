/**
 * 
 */
package br.com.sampleapi.ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.sampleapi.domain.Participante;
import br.com.sampleapi.repository.IParticipanteRepository;

/**
 * @author Delano Jr
 *
 */
@Stateless
public class ParticipanteEJBImpl implements Serializable, ParticipanteEJB {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IParticipanteRepository participanteRepository;

	@Override
	public void save(Participante participante) throws Exception {
		participanteRepository.save(participante);
	}

	@Override
	public Participante find(Long id) throws Exception {
		return participanteRepository.find(id);
	}

	@Override
	public List<Participante> findAll() throws Exception {
		return participanteRepository.findAll();
	}

	@Override
	public void delete(Long id) throws Exception {
		participanteRepository.delete(id);
	}

}
