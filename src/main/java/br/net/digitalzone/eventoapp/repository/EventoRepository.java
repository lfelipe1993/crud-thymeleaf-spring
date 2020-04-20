package br.net.digitalzone.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import br.net.digitalzone.eventoapp.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, Long> {
	Evento findByCodigo(long codigo);

}
