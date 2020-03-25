package com.galeria.servicios;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galeria.GaleriaApplication;
import com.galeria.entidades.Transaccion;
import com.galeria.repositorios.ITransaccionRespositorio;

@Service
public class TransaccionServicio implements ITransaccionServicio{
	
	private static Logger LOG = LoggerFactory.getLogger(GaleriaApplication.class);

	@Autowired
	private ITransaccionRespositorio repositorio;
	
	@Override
	public List<Transaccion> getAll() {
		
		return this.repositorio.findAll();
	}

	@Override
	public Transaccion getById(Long id) throws Exception {
		
		return this.repositorio.findById(id).orElse(null);
	}

	@Override
	public Transaccion add(Transaccion transaccion) throws Exception {
		
		LOG.info("Se esta guardando la transaccion");
		
		return this.repositorio.save(transaccion);
		
	}

	@Override
	public Transaccion update(Transaccion transaccion) throws Exception {

		this.repositorio.getOne(transaccion.getId());
		return this.repositorio.save(transaccion);
	}

	@Override
	public void delete(Long id) throws Exception {
		
		this.repositorio.deleteById(id);
		
	}

}
