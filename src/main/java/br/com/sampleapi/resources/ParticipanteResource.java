/**
 * 
 */
package br.com.sampleapi.resources;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.sampleapi.domain.Participante;
import br.com.sampleapi.ejb.ParticipanteEJB;

/**
 * @author Delano Jr
 *
 */
@Path("/participante")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ParticipanteResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ParticipanteEJB participanteEJB;

	@Path("/create")
	@POST
	public Response create(Participante participante) {
		try {
			participanteEJB.save(participante);
			return Response.ok(participante).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Path("/list")
	@GET
	public Response list() {
		try {
			List<Participante> participantes = participanteEJB.findAll();
			return Response.ok(participantes).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
