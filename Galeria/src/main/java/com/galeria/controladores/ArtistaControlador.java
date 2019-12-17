package com.galeria.controladores;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.galeria.entidades.Artista; 
import com.galeria.servicios.ArtistaServicio;


@Controller
@RequestMapping("/")
public class ArtistaControlador {

	@Autowired
	private ArtistaServicio artistaServicio;
	
	@GetMapping(value = "artista/list")
	public String listar(Model model) {
	
		model.addAttribute("artistas",  this.artistaServicio.getAllArtist());
		
		return "artistaLista";
	}
	
	@GetMapping(value = "artista/add")
	public String add(Model model) {
		Artista artista = new Artista();
		model.addAttribute("artista", artista);
	
		return "artistaNuevo" ;
	}
	
	@PostMapping(value = "artista/save")
	public String save(Artista artista) {
		
		this.artistaServicio.addArtist(artista);
		
		return "redirect:/artista/list";
			
	}
	
	@GetMapping(value = "artista/delete/{id}")
	public String delete(@PathVariable(value="id") Long id) {
		
		this.artistaServicio.deleteArtist(id);
		
		return "redirect:/artista/list";
	}
	
}
