package com.galeria.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galeria.entidades.Cliente;
import com.galeria.repositorios.ClienteRepositorio;

@Service
public class ClienteServicio implements IClienteServicio{

	@Autowired
	private ClienteRepositorio repositorio;
	
	@Override
	public List<Cliente> getAll() {
	
		return (List<Cliente>) this.repositorio.findAll();
		
	}

	@Override
	public Cliente getById(Long id) {
	
		return this.repositorio.findById(id).orElse(null);
		
	}

	@Override
	public synchronized boolean add(Cliente cliente) {
		
		return this.repositorio.save(cliente) != null;
	
	}

	@Override
	public void update(Cliente cliente) {
		
		this.repositorio.save(cliente);
		
	}

	@Override
	public void delete(Long id) {

		this.repositorio.deleteById(id);
		
	}

}
