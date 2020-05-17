package com.galeria.controladores;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galeria.servicios.IArticuloServicio;
import com.galeria.servicios.IArtistaServicio;
import com.galeria.servicios.IClienteServicio;
import com.galeria.GaleriaApplication;
import com.galeria.entidades.Articulo;
import com.galeria.entidades.Artista;
import com.galeria.entidades.Cliente;

@RestController
@RequestMapping("/rest")
public class RestControlador {
	
	private static Logger LOG = LoggerFactory.getLogger(GaleriaApplication.class);
	
	/*
	 * Clientes
	 * 
	 * */
	
	@Autowired
	private IClienteServicio clienteServicio;
	
	@GetMapping(value = "/cliente")
	public ResponseEntity<List<Cliente>> clienteList(){
		
		LOG.info("Listando clientes");
		
		return new ResponseEntity<List<Cliente>>(this.clienteServicio.getAll(),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/cliente/{id}")
	public ResponseEntity<?> borrarCliente(@PathVariable(value = "id") Long id) {
		
		try {
			this.clienteServicio.delete(id);		
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
	}

	/*
	 * Artistas
	 * 
	 * */

	@Autowired
	private IArtistaServicio artistaServicio;
	
	@GetMapping(value = "/artista")
	public ResponseEntity<List<Artista>> artistaList(){	
		LOG.info("Listando artistas");
		return new ResponseEntity<>(this.artistaServicio.getAll(),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/artista/{id}")
	public ResponseEntity<String> borrarArtista(@PathVariable(value = "id") Long id)  {
		
		LOG.info("Borrando Artista");
		

		try {		
			this.artistaServicio.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (Exception e) {
			LOG.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}		
			
	
	}
	
	/*
	 * Articulos
	 * 
	 * */

	@Autowired
	private IArticuloServicio articuloServicio;
	
	@GetMapping(value = "/articulo")
	public ResponseEntity<List<Articulo>> articuloList(){	
		
		LOG.info("Listando articulos");
		return new ResponseEntity<List<Articulo>>(this.articuloServicio.getAll(),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/articulo/{id}")
	public ResponseEntity<String> borrarArticulo(@PathVariable(value = "id") Long id) {
		
		try {
			this.articuloServicio.delete(id);		
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
	}
	
}
