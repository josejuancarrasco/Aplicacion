package com.galeria.servicios;

import java.util.List;

import com.galeria.entidades.Cliente;

public interface IClienteServicio {

	List<Cliente> getAll();

	Cliente getById(Long id);

	Cliente add(Cliente cliente);

	Cliente update(Cliente cliente);

	void delete(Long id);

	List<Cliente> buscarPorNombre(String nombre);
}
