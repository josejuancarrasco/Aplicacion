package com.galeria.servicios;


import java.util.List;

import javax.naming.NameNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;

import com.galeria.entidades.Cliente;

public interface IClienteServicio {

	List<Cliente> getAll();

	Cliente getById(Long id) throws Exception;

	Cliente add(Cliente cliente) throws Exception;

	Cliente update(Cliente cliente) throws Exception;

	void delete(Long id) throws DataIntegrityViolationException;

	List<Cliente> buscarPorNombre(String nombre) throws NameNotFoundException;
}
