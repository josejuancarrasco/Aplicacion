package com.galeria.servicios;

import java.util.List;

import javax.naming.NameNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galeria.GaleriaApplication;
import com.galeria.entidades.Cliente;
import com.galeria.repositorios.IClienteRepositorio;

@Service
public class ClienteServicio implements IClienteServicio {

	private static Logger LOG = LoggerFactory.getLogger(GaleriaApplication.class);

	@Autowired
	private IClienteRepositorio repositorio;


	@Override
	public List<Cliente> getAll() {

		return (List<Cliente>) this.repositorio.findAll();

	}

	@Override
	public Cliente getById(Long id){

		return this.repositorio.findById(id).orElse(null);

	}

	@Override
	public Cliente add(Cliente cliente){

		LOG.info("Se añadio el cliente: " + cliente.getNombre());

		return this.repositorio.save(cliente);

	}

	@Override
	public Cliente update(Cliente cliente) throws Exception{
		
		//Trae una instancia de la clase al contexto para poder actualizarla.
		this.repositorio.getOne(cliente.getId());
		
		return this.repositorio.save(cliente);
		
	}

	@Override
	public void delete(Long id){

		this.repositorio.deleteById(id);

	}

	@Override
	public List<Cliente> buscarPorNombre(String nombre) throws NameNotFoundException{

		return this.repositorio.findByNombre(nombre);

	}

}
