package com.galeria.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.galeria.entidades.Artista;

@Repository
public interface ArtistaRepositorio extends CrudRepository<Artista, Long>  {

	List<Artista> buscarNombre(String name);
	
}
