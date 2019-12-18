package com.galeria.servicios;

import java.util.List;

import com.galeria.entidades.Articulo;

public interface IArticuloServicio {

	List<Articulo> getAll();
	
	Articulo getById(Long id);
	
	boolean add(Articulo articulo);
	
	void update(Articulo articulo);
	
	void delete(Long id);
	
}
