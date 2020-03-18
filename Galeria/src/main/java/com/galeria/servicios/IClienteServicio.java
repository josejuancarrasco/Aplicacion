package com.galeria.servicios;

import java.util.List;

import javax.naming.NameNotFoundException;

import com.galeria.entidades.Cliente;

public interface IClienteServicio {

	List<Cliente> getAll();

	Cliente getById(Long id) throws Exception;

	Cliente add(Cliente cliente) throws Exception;

	Cliente update(Cliente cliente) throws Exception;

	void delete(Long id) throws Exception;

	List<Cliente> buscarPorNombre(String nombre) throws NameNotFoundException;
}
