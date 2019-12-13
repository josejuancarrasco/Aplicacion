package com.galeria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.galeria.servicios.ArtistaServicio;

@Controller
public class ArtistaControlador {

	@Autowired
	private ArtistaServicio artistaServicio;
	
	
	
}
