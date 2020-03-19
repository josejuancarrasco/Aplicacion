package com.galeria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.galeria.entidades.Imagen;

@Repository
public interface IimagenRepositorio extends JpaRepository<Imagen,Long>{

}
