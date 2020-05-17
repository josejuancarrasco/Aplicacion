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

import com.galeria.GaleriaApplication;
import com.galeria.entidades.Transaccion;
import com.galeria.servicios.IArticuloServicio;
import com.galeria.servicios.ITransaccionServicio;

@Controller()
@RequestMapping(value = "/transaccion")
public class TransaccionControlador {
	
	private static Logger LOG = LoggerFactory.getLogger(GaleriaApplication.class);
	
	@Autowired
	private ITransaccionServicio servicioTransaccion;
	
	@Autowired
	private IArticuloServicio servicioArticulo;
	
	@GetMapping(value = "/list")
	public String listar(Model model) {
		model.addAttribute(this.servicioTransaccion.getAll());
		return "";
	}

	@PostMapping(value = "/add")
	public String add(@Valid Transaccion transaccion,BindingResult result ,Model model) throws Exception {
		
		LOG.info("Guardando Transaccion");
		
		if (result.hasErrors()) {
			
			return "articulo/articuloDetalle";
			
		}
	
		this.servicioTransaccion.add(transaccion);
		
		model.addAttribute("articulo", this.servicioArticulo.getById(transaccion.getArticulo().getId()));
		
		return "articulo/articuloDetalle";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable( value = "id") Long id) throws Exception {
		
		Long articuloId = this.servicioTransaccion.getById(id).getArticulo().getId();
		
		this.servicioTransaccion.delete(id);
		
		return "redirect:/articulo/" + articuloId + "/detalle";
	}
	
}
