package com.galeria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.galeria.entidades.Cliente;
import com.galeria.servicios.ClienteServicio;

@Controller
@RequestMapping("/")
public class ClienteControlador {
	
	@Autowired
	private ClienteServicio servicio;
	
	@GetMapping(value = "cliente/list")
	public String list(Model model) {
		
		model.addAttribute("clientes" ,this.servicio.getAll());
		
		return "clienteLista";
	}
	
	@GetMapping(value = "cliente/add")
	public String add(Model model) {
		
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
	
		return "clienteNuevo" ;
	}
	
	@PostMapping(value = "cliente/save")
	public String save(Cliente cliente) {
		
		this.servicio.add(cliente);
		
		return "redirect:/cliente/list";
			
	}
	
	@GetMapping(value = "cliente/delete/{id}")
	public String delete(@PathVariable(value="id") Long id) {
		
		this.servicio.delete(id);
		
		return "redirect:/cliente/list";
	}
	
}
