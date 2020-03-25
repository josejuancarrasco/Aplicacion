package com.galeria.servicios;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.galeria.entidades.Articulo;
import com.galeria.repositorios.IArticuloRepositorio;

@Service
public class ArticuloServicio implements IArticuloServicio {

	@Autowired
	private IArticuloRepositorio repositorio;

	@Override
	public List<Articulo> getAll() {

		return (List<Articulo>) this.repositorio.findAll(Sort.by(Direction.DESC, "id"));
		
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

		this.repositorio.getOne(articulo.getId());
		
		
		return this.repositorio.save(articulo);

	}

	@Override
	public void delete(Long id) {
		
		this.repositorio.deleteById(id);
		
	}

}
