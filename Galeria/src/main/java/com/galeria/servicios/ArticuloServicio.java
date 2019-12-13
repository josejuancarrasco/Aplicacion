package com.galeria.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.galeria.entidades.Articulo;
import com.galeria.repositorios.ArticuloRepositorio;

@Service
public class ArticuloServicio implements IArticuloServicio{

	private ArticuloRepositorio repositorio;
	
	@Override
	public List<Articulo> getAllArticulo() {
		
		return (List<Articulo>) this.repositorio.findAll() ;
	}

	@Override
	public Articulo getArticuloById(Long id) {

		return this.repositorio.findById(id).orElse(null);
		
	}

	@Override
	public boolean addArticulo(Articulo articulo) {
		
		return this.repositorio.save(articulo) != null;
		
	}

	@Override
	public void updateArticulo(Articulo articulo) {

		this.repositorio.save(articulo);
		
	}

	@Override
	public void deleteArticulo(Long id) {
		
		this.repositorio.deleteById(id);;
		
	}

}
