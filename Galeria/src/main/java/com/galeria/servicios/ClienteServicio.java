package com.galeria.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.galeria.entidades.Cliente;
import com.galeria.repositorios.ClienteRepositorio;

@Service
public class ClienteServicio implements IClienteServicio{

	private ClienteRepositorio repositorio;
	
	@Override
	public List<Cliente> getAllCliente() {
	
		return (List<Cliente>) this.repositorio.findAll();
		
	}

	@Override
	public Cliente getClienteById(Long id) {
	
		return this.repositorio.findById(id).orElse(null);
		
	}

	@Override
	public boolean addCliente(Cliente cliente) {
		
		return this.repositorio.save(cliente) != null;
	
	}

	@Override
	public void updateCliente(Cliente cliente) {
		
		this.repositorio.save(cliente);
		
	}

	@Override
	public void deleteCliente(Long id) {

		this.repositorio.deleteById(id);
		
	}

}
