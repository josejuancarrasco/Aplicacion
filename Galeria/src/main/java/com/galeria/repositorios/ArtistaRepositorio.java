package com.galeria.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.galeria.entidades.Artista;

@Repository
public interface ArtistaRepositorio extends JpaRepository<Artista, Long>  {

	//List<Artista> buscarNombre(String name);
	
}
