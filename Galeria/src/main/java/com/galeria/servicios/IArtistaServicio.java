package com.galeria.servicios;


import java.util.List;

import com.galeria.entidades.Artista;


public interface IArtistaServicio {

	List<Artista> getAllArtist();
	
	Artista getArtistById(Long id);
	
	boolean addArtist(Artista artista);
	
	void updateArtist(Artista artist);
	
	void deleteArtist(Long id);
	
}
