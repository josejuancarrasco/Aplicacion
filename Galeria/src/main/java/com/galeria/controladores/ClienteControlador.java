package com.galeria.controladores;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.galeria.GaleriaApplication;
import com.galeria.entidades.Cliente;
import com.galeria.servicios.IClienteServicio;


@Controller
@RequestMapping("/cliente")
public class ClienteControlador {

	private static Logger LOG = LoggerFactory.getLogger(GaleriaApplication.class);

	@Autowired
	private IClienteServicio servicio;

	@GetMapping(value = "/list")
	public String list(Model model) {

		LOG.info("Listando clientes");

		model.addAttribute("clientes", this.servicio.getAll());

		return "cliente/clienteLista";
	}

	@GetMapping(value = "/add")
	public String add(Model model) {

		Cliente cliente = new Cliente();
		
		model.addAttribute("editar", false);
		model.addAttribute("cliente", cliente);

		return "cliente/cliente";
	}

	@PostMapping(value = "/add")
	public String add(@Valid Cliente cliente, BindingResult result, RedirectAttributes redirectAttributes,
			Model model) throws Exception {

		if (result.hasErrors()) {
			return "cliente/cliente";
		}

		this.servicio.add(cliente);


		redirectAttributes.addFlashAttribute("mensaje", "Guardado correctamente").addFlashAttribute("clase", "success");

		return "redirect:/cliente/list";

	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, RedirectAttributes redirectAttributes, Model model) throws Exception {

		this.servicio.delete(id);

		redirectAttributes.addFlashAttribute("mensaje", "Eliminado correctamente").addFlashAttribute("clase","warning");

		return "redirect:/cliente/list";
	}

	@GetMapping(value = "/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) throws Exception {
	
		model.addAttribute("editar", true);
		model.addAttribute(this.servicio.getById(id));

		return "cliente/cliente";
	}

	@PostMapping(value = "/editar/{id}")
	public String editar(@Valid Cliente cliente, BindingResult result, RedirectAttributes redirectAttributes, Model model) throws Exception {

		
		if (result.hasErrors()) {
			return "cliente/cliente";
		}
		
		this.servicio.update(cliente);

		redirectAttributes.addFlashAttribute("mensaje", "Modificado correctamente").addFlashAttribute("clase",
				"success");

		return "redirect:/cliente/list";
	}

}
