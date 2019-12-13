package com.galeria.servicios;

import java.util.List;

import com.galeria.entidades.Cliente;

public interface IClienteServicio {
	
	List<Cliente> getAllCliente();
	
	Cliente getClienteById(Long id);
	
	boolean addCliente(Cliente cliente);
	
	void updateCliente(Cliente cliente);
	
	void deleteCliente(Long id);
}
