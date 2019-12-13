package com.galeria.servicios;

import java.util.List;

import com.galeria.entidades.Articulo;

public interface IArticuloServicio {

	List<Articulo> getAllArticulo();
	
	Articulo getArticuloById(Long id);
	
	boolean addArticulo(Articulo articulo);
	
	void updateArticulo(Articulo articulo);
	
	void deleteArticulo(Long id);
	
}
