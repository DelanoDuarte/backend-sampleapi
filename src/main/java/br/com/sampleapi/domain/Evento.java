/**
 * 
 */
package br.com.sampleapi.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Delano Jr
 *
 */
@Entity
@Table(name = "tb_evento")
@NamedQueries(value = { @NamedQuery(name = "Evento.findAll", query = "select e from Evento e") })
public class Evento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	private String nome;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEvento;

	@Column
	private String observacoes;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_participantes_evento", 
	joinColumns = @JoinColumn(name = "id_evento", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_participante", referencedColumnName = "id"))
	private List<Participante> participantesEventos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<Participante> getParticipantesEventos() {
		return participantesEventos;
	}

	public void setParticipantesEventos(List<Participante> participantesEventos) {
		this.participantesEventos = participantesEventos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEvento == null) ? 0 : dataEvento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
		result = prime * result + ((participantesEventos == null) ? 0 : participantesEventos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (dataEvento == null) {
			if (other.dataEvento != null)
				return false;
		} else if (!dataEvento.equals(other.dataEvento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (observacoes == null) {
			if (other.observacoes != null)
				return false;
		} else if (!observacoes.equals(other.observacoes))
			return false;
		if (participantesEventos == null) {
			if (other.participantesEventos != null)
				return false;
		} else if (!participantesEventos.equals(other.participantesEventos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nome=" + nome + ", dataEvento=" + dataEvento + ", observacoes=" + observacoes
				+ ", participantesEventos=" + participantesEventos + "]";
	}

}
