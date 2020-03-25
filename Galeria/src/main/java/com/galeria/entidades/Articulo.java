package com.galeria.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;


import com.galeria.enumeraciones.TipoTransaccion;
import com.galeria.enumeraciones.TipoArticulo;

@Entity
public class Articulo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "El título es obligatorio")
	private String titulo;

	@Enumerated(value = EnumType.STRING)
	private TipoArticulo tipo;

	//@NotBlank(message = "Una pequeña descripción es necesaria")
	private String descripcion;

	private Boolean firmado;

	private Integer numeracion;

	private String editor;

	private String medidas;

	private String pisada;

	@Enumerated(value = EnumType.STRING)
	private TipoTransaccion estado;

	@Lob
	private String foto64;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_artista", nullable = false)
	private Artista artista;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "articulo")
	private List<Transaccion> transacciones;
	
	public Articulo() {
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public TipoArticulo getTipo() {
		return tipo;
	}

	public void setTipo(TipoArticulo tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getFirmado() {
		return firmado;
	}

	public void setFirmado(Boolean firmado) {
		this.firmado = firmado;
	}

	public Integer getNumeracion() {
		return numeracion;
	}

	public void setNumeracion(Integer numeracion) {
		this.numeracion = numeracion;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getMedidas() {
		return medidas;
	}

	public void setMedidas(String medidas) {
		this.medidas = medidas;
	}

	public String getPisada() {
		return pisada;
	}

	public void setPisada(String pisada) {
		this.pisada = pisada;
	}


	public TipoTransaccion getEstado() {
		return estado;
	}

	public void setEstado(TipoTransaccion estado) {
		this.estado = estado;
	}


	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public String getFoto64() {
		return foto64;
	}

	public void setFoto64(String foto64) {
		this.foto64 = foto64;
	}

	public List<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}


	
}
