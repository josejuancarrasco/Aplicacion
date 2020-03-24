package com.galeria.servicios;

import java.util.List;

import com.galeria.entidades.Transaccion;

public interface ITransaccionServicio {
	
	public List<Transaccion> getAll() ;
	
	public Transaccion getById(Long id) throws Exception;
	
	public Transaccion add(Transaccion transaccion) throws Exception;
	
	public Transaccion update(Transaccion transaccion) throws Exception;
	
	public void delete(Long id) throws Exception;

}
