/**
 * 
 */
package br.com.sampleapi.repository;

import java.util.List;

import br.com.sampleapi.domain.Evento;

/**
 * @author Delano Jr
 *
 */
public interface IEventoRepository {

	public void save(Evento evento) throws Exception;

	public Evento find(Long id) throws Exception;

	public List<Evento> findAll() throws Exception;

	public void delete(Long id) throws Exception;
}
