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
	public List<Artista> getAll() {
		
		return this.repositorio.findAll();
		
	}

	@Override
	public Artista getById(Long id) {
		Artista artista = this.repositorio.findById(id).orElse(null);
		return artista;
	}

	@Override
	public synchronized boolean add(Artista artista) {
		
		return this.repositorio.save(artista) != null;
		
	}

	@Override
	public void update(Artista artist) {
		
		this.repositorio.save(artist);
		
	}

	@Override
	public void delete(Long id) {
		this.repositorio.deleteById(id);
		
	}

}
