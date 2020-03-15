package com.galeria.entidades;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Entity
public class Artista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "El nombre es obligatorio")
	private String nombre;

	@NotBlank(message = "El primer apellido es obligatorio")
	private String apellido_1;

	private String apellido_2;

	private String lugar_nac;

	private String lugar_fall;

	private LocalDate fecha_nac;

	private LocalDate fecha_fall;

	@Valid
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "artista")
	List<Articulo> articulos;

	public Artista() {
	}

	public Long getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido_1() {
		return apellido_1;
	}

	public void setApellido_1(String apellido_1) {
		this.apellido_1 = apellido_1;
	}

	public String getApellido_2() {
		return apellido_2;
	}

	public void setApellido_2(String apellido_2) {
		this.apellido_2 = apellido_2;
	}

	public String getLugar_nac() {
		return lugar_nac;
	}

	public void setLugar_nac(String lugar_nac) {
		this.lugar_nac = lugar_nac;
	}

	public String getLugar_fall() {
		return lugar_fall;
	}

	public void setLugar_fall(String lugar_fall) {
		this.lugar_fall = lugar_fall;
	}

	public LocalDate getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public LocalDate getFecha_fall() {
		return fecha_fall;
	}

	public void setFecha_fall(LocalDate fecha_fall) {
		this.fecha_fall = fecha_fall;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	
}
