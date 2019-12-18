package com.galeria.servicios;


import java.util.List;

import com.galeria.entidades.Artista;


public interface IArtistaServicio {

	List<Artista> getAll();
	
	Artista getById(Long id);
	
	boolean add(Artista artista);
	
	void update(Artista artist);
	
	void delete(Long id);
	
}
