package com.galeria.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import com.galeria.enumeraciones.EstadoArticulo;
import com.galeria.enumeraciones.TipoArticulo;

@Entity
public class Articulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_artista" , nullable = false )
	private Artista artista;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_cliente", nullable = false)
	private Cliente cliente;
	
	@NotBlank(message = "El título es obligatorio")
	private String titulo;

	@NotBlank(message = "El tipo es obligatorio")
	@Enumerated(value = EnumType.STRING)
	private TipoArticulo tipo;
	
	@NotBlank(message = "Una pequeña descripción es necesaria")
	private String descripcion;
	
	private Boolean firmado;
	
	private Integer numeracion;
	
	private String editor;
	
	private String medidas;
	
	private String pisada;
	
	private String comentarios;
	
	@Enumerated(value = EnumType.STRING)
	private EstadoArticulo estado;
	
	@NotBlank(message = "El precio es obligatorio")
	private Float precio;
	
	public Articulo() {}

	public Articulo(Long id, Artista artista, Cliente cliente,
			@NotBlank(message = "El título es obligatorio") String titulo,
			@NotBlank(message = "El tipo es obligatorio") TipoArticulo tipo,
			@NotBlank(message = "Una pequeña descripción es necesaria") String descripcion, Boolean firmado,
			Integer numeracion, String editor, String medidas, String pisada, String comentarios, EstadoArticulo estado,
			@NotBlank(message = "El precio es obligatorio") Float precio) {
		super();
		this.id = id;
		this.artista = artista;
		this.cliente = cliente;
		this.titulo = titulo;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.firmado = firmado;
		this.numeracion = numeracion;
		this.editor = editor;
		this.medidas = medidas;
		this.pisada = pisada;
		this.comentarios = comentarios;
		this.estado = estado;
		this.precio = precio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public EstadoArticulo getEstado() {
		return estado;
	}

	public void setEstado(EstadoArticulo estado) {
		this.estado = estado;
	}
	
	
}
