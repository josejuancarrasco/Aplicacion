package com.galeria.repositorios;

import java.util.List;

import javax.naming.NameNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.galeria.entidades.Cliente;

@Repository
public interface IClienteRepositorio extends JpaRepository<Cliente, Long> {

	public List<Cliente> findByNombre(String nombre) throws NameNotFoundException;
	
}
