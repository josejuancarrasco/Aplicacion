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
		
		model.addAttribute("editar", false);
		model.addAttribute("artista", artista);

		return "artista/artista";
	}

	@PostMapping(value = "/add")
	public String save(@Valid Artista artista, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			return "artista/artista";
		}

		this.servicio.add(artista);

		return "redirect:/artista/list";

	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id) throws Exception{

		this.servicio.delete(id);

		return "redirect:/artista/list";
	}

	@GetMapping(value = "/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id,Model model) throws Exception{
		
		model.addAttribute("editar", true);
		model.addAttribute(this.servicio.getById(id));
		
		return "artista/artista";
	}
	
	@PostMapping(value = "/editar/{id}")
	public String editar(@Valid Artista artista,BindingResult result, RedirectAttributes redirectAttributes) throws Exception{
		
		if (result.hasErrors()) {
			return "artista/artista";
		}
		
		this.servicio.add(artista);
		
		redirectAttributes.addFlashAttribute("mensaje", "Modificado correctamente").addFlashAttribute("clase", "success");
		
		return "redirect:/artista/list";
	}
}
