package com.galeria.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galeria.entidades.Articulo;
import com.galeria.repositorios.IArticuloRepositorio;

@Service
public class ArticuloServicio implements IArticuloServicio {

	@Autowired
	private IArticuloRepositorio repositorio;

	@Override
	public List<Articulo> getAll() {

		return (List<Articulo>) this.repositorio.findAll();
	}

	@Override
	public Articulo getById(Long id) {

		return this.repositorio.findById(id).orElse(null);

	}

	@Override
	public  Articulo add(Articulo articulo) {

		return this.repositorio.save(articulo);

	}

	@Override
	public Articulo update(Articulo articulo) {

		return this.repositorio.save(articulo);

	}

	@Override
	public void delete(Long id) {
		
		this.repositorio.deleteById(id);
		
	}

}
