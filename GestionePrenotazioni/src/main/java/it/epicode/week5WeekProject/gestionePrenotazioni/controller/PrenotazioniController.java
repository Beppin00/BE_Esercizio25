package it.epicode.week5WeekProject.gestionePrenotazioni.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import it.epicode.week5WeekProject.gestionePrenotazioni.DAO.PostazioneService;
import it.epicode.week5WeekProject.gestionePrenotazioni.DAO.UtenteService;
import it.epicode.week5WeekProject.gestionePrenotazioni.model.Postazione;
import it.epicode.week5WeekProject.gestionePrenotazioni.model.Utente;

@Controller
public class PrenotazioniController {
	
	@Autowired
	private UtenteService us;
	
	@Autowired
	private PostazioneService ps;
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello world";
	}
	
	@GetMapping("/prenotazioni/{lan}")
	@ResponseBody
	public String language(@PathVariable String lan) {
		
		switch (lan) {
		case "en":
			return "The content is in English";
		case "it":
			return "Il contenuto è in Italiano";
		default:
			return("ERROR Unexpected value: " + lan);
		}
	}
	
	@GetMapping("/users")
	@ResponseBody
	public List<Utente> getAll() {
		return us.getAll();
	}
	
	@GetMapping("/postazioni/{tipo}")
	@ResponseBody
	public List<Postazione> getAll(@PathVariable String tipo) {
		switch (tipo) {
		case "openspace": 
			return ps.getOpenSpace();
		case "privato":
			return ps.getPrivato();
		case "salariunioni":
			return ps.getSalaRiunioni();
		default:
			return new ArrayList<>();
		}
	}
	
}
