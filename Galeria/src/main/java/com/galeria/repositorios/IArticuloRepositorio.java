package com.galeria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.galeria.entidades.Articulo;

@Repository
public interface IArticuloRepositorio extends JpaRepository<Articulo, Long> {

}
