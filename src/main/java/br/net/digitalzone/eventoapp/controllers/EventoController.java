package br.net.digitalzone.eventoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.net.digitalzone.eventoapp.models.Convidado;
import br.net.digitalzone.eventoapp.models.Evento;
import br.net.digitalzone.eventoapp.repository.ConvidadoRepository;
import br.net.digitalzone.eventoapp.repository.EventoRepository;

@Controller
public class EventoController {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private ConvidadoRepository convidadoRepository;
	
	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String form(Evento evento) {
		
		eventoRepository.save(evento);
		
		return "redirect:/cadastrarEvento";
	}
	
	@RequestMapping(value = "/eventos")
	public ModelAndView listaEventos() {

		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = eventoRepository.findAll();
		mv.addObject("eventos", eventos);
		
		return mv;
		
	}
	
	@RequestMapping(value = "/{codigo}", method =  RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo) {
		Evento evento = eventoRepository.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		mv.addObject("evento", evento);
		System.out.println("Evento: " + evento);
		
		
		Iterable<Convidado> convidados = convidadoRepository.findByEvento(evento);
		mv.addObject("convidados", convidados);
		
		return mv;
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
	public String detalhesEventoPost(@PathVariable("codigo") long codigo, Convidado convidado) {
		Evento evento = eventoRepository.findByCodigo(codigo);
		convidado.setEvento(evento);
		
		convidadoRepository.save(convidado);
		
		return "redirect:/{codigo}";
	}
	
}