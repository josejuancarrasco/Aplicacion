package com.galeria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.galeria.entidades.Transaccion;
import com.galeria.servicios.ITransaccionServicio;

@Controller()
@RequestMapping(value = "/transaccion")
public class TransaccionControlador {
	
	@Autowired
	private ITransaccionServicio servicioTransaccion;
	
	@GetMapping(value = "/list")
	public String listar(Model model) {
		model.addAttribute(this.servicioTransaccion.getAll());
		return "";
	}

	@GetMapping(value = "/add")
	public String add(Model model) {
		
		model.addAttribute(new Transaccion());
		
		return "";
	}
	
}
