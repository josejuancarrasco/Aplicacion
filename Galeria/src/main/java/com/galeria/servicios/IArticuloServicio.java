package com.galeria.servicios;

import java.util.List;

import com.galeria.entidades.Articulo;

public interface IArticuloServicio {

	List<Articulo> getAll();

	Articulo getById(Long id) throws Exception;

	Articulo add(Articulo articulo) throws Exception;

	Articulo update(Articulo articulo) throws Exception;

	void delete(Long id) throws Exception;

}
