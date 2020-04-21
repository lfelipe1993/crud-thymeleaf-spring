package br.net.digitalzone.eventoapp.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Convidado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@NotEmpty
	private String rg;
	@NotEmpty
	private String nomeConvidado;
	
	@ManyToOne
	private Evento evento;
	
	public Convidado() {
	}

	public Convidado(String rg, String nomeConvidado, Evento evento) {
		super();
		this.rg = rg;
		this.nomeConvidado = nomeConvidado;
		this.evento = evento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNomeConvidado() {
		return nomeConvidado;
	}

	public void setNomeConvidado(String nomeConvidado) {
		this.nomeConvidado = nomeConvidado;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	

}
