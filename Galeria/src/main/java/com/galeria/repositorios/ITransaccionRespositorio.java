package com.galeria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.galeria.entidades.Transaccion;

@Repository
public interface ITransaccionRespositorio extends JpaRepository<Transaccion,Long> {

}
