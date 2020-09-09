package com.galeria.entidades;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.galeria.enumeraciones.TipoTransaccion;

@Entity
public class Transaccion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Enumerated
	private TipoTransaccion tipoTransaccion;
	
	@Temporal(TemporalType.DATE)
	private Calendar fechaTransaccion;
	
	private Long precio;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_articulo", nullable = false)
	@JsonIgnore
	private Articulo articulo;
	
	public Transaccion() {
		
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public TipoTransaccion getTipoTransaccion() {
		return tipoTransaccion;
	}


	public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}


	public Calendar getFechaTransaccion() {
		return fechaTransaccion;
	}


	public void setFechaTransaccion(Calendar fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}


	public Long getPrecio() {
		return precio;
	}


	public void setPrecio(Long precio) {
		this.precio = precio;
	}


	public Articulo getArticulo() {
		return articulo;
	}


	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
