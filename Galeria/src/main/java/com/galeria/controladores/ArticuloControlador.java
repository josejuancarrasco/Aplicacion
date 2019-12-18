package com.galeria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.galeria.entidades.Articulo;
import com.galeria.entidades.Artista;
import com.galeria.servicios.ArticuloServicio;

@Controller
@RequestMapping(value = "")
public class ArticuloControlador {
	@Autowired
	private ArticuloServicio servicio;
	
	@GetMapping(value = "articulo/list")
	public String list(Model model) {
	
		model.addAttribute("articulo",  this.servicio.getAll());
		
		return "articuloLista";
	}
	
	@GetMapping(value = "articulo/add")
	public String add(Model model) {
		
		Artista artista = new Artista();
		model.addAttribute("artista", artista);
	
		return "articuloNuevo" ;
	}
	
	@PostMapping(value = "articulo/save")
	public String save(Articulo articulo) {
		
		this.servicio.add(articulo);
		
		return "redirect:/articulo/list";
			
	}
	
	@GetMapping(value = "articulo/delete/{id}")
	public String delete(@PathVariable(value="id") Long id) {
		
		this.servicio.delete(id);
		
		return "redirect:/articulo/list";
	}
}
