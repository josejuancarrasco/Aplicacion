package com.galeria.servicios;

import java.util.List;

import com.galeria.entidades.Cliente;

public interface IClienteServicio {
	
	List<Cliente> getAll();
	
	Cliente getById(Long id);
	
	boolean add(Cliente cliente);
	
	void update(Cliente cliente);
	
	void delete(Long id);
}
