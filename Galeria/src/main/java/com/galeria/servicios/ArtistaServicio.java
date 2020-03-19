package com.galeria.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.galeria.entidades.Artista;
import com.galeria.repositorios.IArtistaRepositorio;

@Service
public class ArtistaServicio implements IArtistaServicio {

	@Autowired
	private IArtistaRepositorio repositorio;

	@Override
	public List<Artista> getAll() {

		return this.repositorio.findAll();

	}

	@Override
	public Artista getById(Long id) {
		return this.repositorio.findById(id).orElse(null);
	}

	@Override
	public synchronized Artista add(Artista artista) {

		return this.repositorio.save(artista);

	}

	@Override
	public Artista update(Artista artista) {
		
		this.repositorio.getOne(artista.getId());

		return this.repositorio.save(artista);

	}

	@Override
	public void delete(Long id) {
		this.repositorio.deleteById(id);
	}

}
