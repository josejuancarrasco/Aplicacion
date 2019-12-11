package com.galeria.entidades;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
public class Artista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	 
	@NotBlank(message = "El nombre es obligatorio")
	private String nombre;

    @NotBlank(message = "El primer es obligatorio")
    private String apellido_1;
 
    private String apellido_2;
    
    private String lugar_nacimiento;
    
    private String lugar_fallecimiento;
    
    @Temporal(TemporalType.DATE)
    private Calendar fecha ;
    
    @Temporal(TemporalType.DATE)
    private Calendar fecha_fall;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getLugar_nacimiento() {
		return lugar_nacimiento;
	}

	public void setLugar_nacimiento(String lugar_nacimiento) {
		this.lugar_nacimiento = lugar_nacimiento;
	}

	public String getLugar_fallecimiento() {
		return lugar_fallecimiento;
	}

	public void setLugar_fallecimiento(String lugar_fallecimiento) {
		this.lugar_fallecimiento = lugar_fallecimiento;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public Calendar getFecha_fall() {
		return fecha_fall;
	}

	public void setFecha_fall(Calendar fecha_fall) {
		this.fecha_fall = fecha_fall;
	}
    
    
	
}
