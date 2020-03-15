package com.galeria.controladores;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.galeria.entidades.Articulo;
import com.galeria.servicios.IArticuloServicio;
import com.galeria.servicios.IArtistaServicio;



@Controller
@RequestMapping(value = "/articulo")
public class ArticuloControlador {

	@Autowired
	private IArticuloServicio servicioArticulo;
	
	@Autowired
	private IArtistaServicio servicioArtista;

	@GetMapping(value = "/list")
	public String list(Model model) {

		model.addAttribute("articulos", this.servicioArticulo.getAll());

		return "articulo/articuloLista";
	}

	@GetMapping(value = "/add")
	public String add(Model model) {

		model.addAttribute("articulo", new Articulo());
		
		model.addAttribute("artistas", this.servicioArtista.getAll());

		return "articulo/articuloNuevo";
	}

	@PostMapping(value = "/add")
	public String save(@Valid Articulo articulo, BindingResult result) {

		if (result.hasErrors()) {
			return "articulo/articuloNuevo";
		}

		this.servicioArticulo.add(articulo);

		return "redirect:/articulo/list";

	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id) {

		this.servicioArticulo.delete(id);

		return "redirect:/articulo/list";
	}
}
