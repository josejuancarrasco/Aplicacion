package com.galeria.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.galeria.entidades.Articulo;

@Repository
public interface ArticuloRepositorio extends CrudRepository< Articulo, Long>{
		
}
