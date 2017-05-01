/**
 * 
 */
package br.com.sampleapi.ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.sampleapi.domain.Evento;
import br.com.sampleapi.repository.IEventoRepository;

/**
 * @author Delano Jr
 *
 */
@Stateless
public class EventoEJBImpl implements EventoEJB, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IEventoRepository eventoRepository;

	@Override
	public void save(Evento evento) throws Exception {
		eventoRepository.save(evento);
	}

	@Override
	public Evento find(Long id) throws Exception {
		return eventoRepository.find(id);
	}

	@Override
	public List<Evento> findAll() throws Exception {
		return eventoRepository.findAll();
	}

	@Override
	public void delete(Long id) throws Exception {
		eventoRepository.delete(id);
	}

}
