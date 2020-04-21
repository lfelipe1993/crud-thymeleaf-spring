package br.net.digitalzone.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import br.net.digitalzone.eventoapp.models.Convidado;
import br.net.digitalzone.eventoapp.models.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String> {
	Iterable<Convidado> findByEvento(Evento evento);
	
	Convidado findByRg(String rg);
}
