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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.galeria.entidades.Artista;
import com.galeria.servicios.IArtistaServicio;

@Controller
@RequestMapping("/artista")
public class ArtistaControlador {

	@Autowired
	private IArtistaServicio servicio;

	@GetMapping(value = "/list")
	public String list(Model model) {

		model.addAttribute("artistas", this.servicio.getAll());

		return "artista/artistaLista";
	}

	@GetMapping(value = "/add")
	public String add(Model model) {

		Artista artista = new Artista();
		model.addAttribute("artista", artista);

		return "artista/artistaNuevo";
	}

	@PostMapping(value = "/add")
	public String save(@Valid Artista artista, BindingResult result) {

		if (result.hasErrors()) {
			return "artista/artistaNuevo";
		}

		this.servicio.add(artista);

		return "redirect:/artista/list";

	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id) {

		this.servicio.delete(id);

		return "redirect:/artista/list";
	}

	@GetMapping(value = "/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id,Model model) {
		
		Artista artista = this.servicio.getById(id);
		model.addAttribute(artista);
		
		return "artista/artistaEditar";
	}
	
	@PostMapping(value = "/editar/{id}")
	public String editar(@Valid Artista artista,BindingResult result, RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
			return "artista/artistaEditar";
		}
		
		this.servicio.add(artista);
		
		redirectAttributes.addFlashAttribute("mensaje", "Modificado correctamente").addFlashAttribute("clase", "success");
		
		return "redirect:/artista/list";
	}
}
