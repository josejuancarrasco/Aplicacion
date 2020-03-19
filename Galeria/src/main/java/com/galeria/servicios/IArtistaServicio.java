package com.galeria.servicios;

import java.util.List;

import com.galeria.entidades.Artista;

public interface IArtistaServicio {

	List<Artista> getAll();

	Artista getById(Long id) throws Exception;

	Artista add(Artista artista) throws Exception;

	Artista update(Artista artist) throws Exception;

	void delete(Long id) throws Exception;

}
