package com.galeria.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.galeria.entidades.Cliente;

@Repository
public interface ClienteRepositorio  extends CrudRepository<Cliente, Long> {

}
