/**
 * 
 */
package br.com.sampleapi.repository;

import java.util.List;

import br.com.sampleapi.domain.Participante;

/**
 * @author Delano Jr
 *
 */
public interface IParticipanteRepository {

	public void save(Participante participante) throws Exception;

	public Participante find(Long id) throws Exception;

	public List<Participante> findAll() throws Exception;

	public void delete(Long id) throws Exception;
}
