/**
 * 
 */
package br.com.sampleapi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Delano Jr
 *
 */
@Entity
@Table(name = "tb_participante")
@NamedQuery(name = "Participante.findAll", query = "select p from Participante p")
public class Participante implements Serializable {

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

	@Column
	private Boolean presencaConfirmada;

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

	public Boolean getPresencaConfirmada() {
		return presencaConfirmada;
	}

	public void setPresencaConfirmada(Boolean presencaConfirmada) {
		this.presencaConfirmada = presencaConfirmada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((presencaConfirmada == null) ? 0 : presencaConfirmada.hashCode());
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
		Participante other = (Participante) obj;
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
		if (presencaConfirmada == null) {
			if (other.presencaConfirmada != null)
				return false;
		} else if (!presencaConfirmada.equals(other.presencaConfirmada))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Participante [id=" + id + ", nome=" + nome + ", presencaConfirmada=" + presencaConfirmada + "]";
	}

}
