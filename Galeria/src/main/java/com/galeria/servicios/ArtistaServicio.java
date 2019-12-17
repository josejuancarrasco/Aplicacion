package com.galeria.servicios;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galeria.entidades.Artista;
import com.galeria.repositorios.ArtistaRepositorio;

@Service
public class ArtistaServicio implements IArtistaServicio{
	
	@Autowired
	private ArtistaRepositorio repositorio;

	@Override
	public List<Artista> getAllArtist() {
		
		return this.repositorio.findAll();
		
	}

	@Override
	public Artista getArtistById(Long id) {
		Artista artista = this.repositorio.findById(id).orElse(null);
		return artista;
	}

	@Override
	public synchronized boolean addArtist(Artista artista) {
		
		return this.repositorio.save(artista) != null;
		
	}

	@Override
	public void updateArtist(Artista artist) {
		
		this.repositorio.save(artist);
		
	}

	@Override
	public void deleteArtist(Long id) {
		this.repositorio.deleteById(id);
		
	}

}
