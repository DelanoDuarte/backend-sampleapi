/**
 * 
 */
package br.com.sampleapi.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.com.sampleapi.domain.Evento;
import br.com.sampleapi.domain.Participante;
import br.com.sampleapi.ejb.EventoEJB;
import br.com.sampleapi.ejb.EventoEJBImpl;
import br.com.sampleapi.ejb.ParticipanteEJB;
import br.com.sampleapi.ejb.ParticipanteEJBImpl;

/**
 * @author Delano Jr
 *
 */

@RequestScoped
public class JPAInsert implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		EventoEJB eventoEJB = new EventoEJBImpl();

		ParticipanteEJB participanteEJB = new ParticipanteEJBImpl();

		List<Participante> participantes = new ArrayList<>();

		Participante participante1 = new Participante();
		participante1.setNome("Jamal Jones");
		participante1.setPresencaConfirmada(true);

		Participante participante2 = new Participante();
		participante2.setNome("Joe Smith");
		participante2.setPresencaConfirmada(false);

		try {
			participanteEJB.save(participante1);
			participanteEJB.save(participante2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		participantes.add(participante1);
		participantes.add(participante2);

		Evento evento = new Evento();
		evento.setNome("Evento 1");
		evento.setFlag_finalizado(false);
		evento.setDataEvento(new Date());
		evento.setParticipantes(participantes);

		try {
			eventoEJB.save(evento);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
