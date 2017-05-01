/**
 * 
 */
package br.com.sampleapi.resources;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.sampleapi.domain.Evento;
import br.com.sampleapi.ejb.EventoEJB;

/**
 * @author Delano Jr
 *
 */
@Path("/evento")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventoResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EventoEJB eventoEJB;

	@Path("/eventos")
	@GET
	public Response eventos() {
		try {
			List<Evento> eventos = eventoEJB.findAll();
			return Response.ok(eventos).build();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Response.serverError().build();
	}

	@Path("/create")
	@POST
	public Response createEvento(Evento evento) {
		try {
			eventoEJB.save(evento);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok(evento).build();
	}

	@Path("/{id}")
	@GET
	public Response find(@PathParam(value = "id") Long id) {

		try {
			Evento evento = eventoEJB.find(id);
			return Response.ok(evento).build();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Path("/{id}")
	@DELETE
	public Response delete(@PathParam(value = "id") Long id) {

		try {
			eventoEJB.delete(id);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Path("/{id}")
	@PUT
	public Response update(@PathParam(value = "id") Long id, Evento evento) {

		try {
			Evento eventoFind = eventoEJB.find(id);
			eventoFind.setNome(evento.getNome());
			eventoFind.setDataEvento(evento.getDataEvento());
			eventoFind.setFlag_finalizado(evento.getFlag_finalizado());
			eventoFind.setObservacoes(evento.getObservacoes());
			eventoEJB.save(eventoFind);

			return Response.ok(evento).build();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
