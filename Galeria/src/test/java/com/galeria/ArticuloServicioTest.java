package com.galeria;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.galeria.entidades.Articulo;
import com.galeria.entidades.Artista;
import com.galeria.enumeraciones.TipoArticulo;
import com.galeria.servicios.IArticuloServicio;
import com.galeria.servicios.IArtistaServicio;


@SpringBootTest
public class ArticuloServicioTest {
	
	@Autowired
	private IArticuloServicio articuloServicio;
	
	@Autowired
	private IArtistaServicio artistaServicio;
	
	private static Articulo articulo;
	private static Artista artista;
	
	@BeforeAll
	public static void setUp() {
		
		artista = new Artista();
		
		artista.setNombre("Jose Juan");
		artista.setApellido_1("Carrasco");
		
		
		articulo = new Articulo();
		
		articulo.setTitulo("Hola mundo");
		articulo.setTipo(TipoArticulo.Escultura);
		articulo.setArtista(artista);
	
	}
	
	@Test
	public void nuevoArticulo() throws Exception {
		
		this.artistaServicio.add(artista);
		this.articuloServicio.add(articulo);
		assertThat(this.articuloServicio.getById(articulo.getId())).isNotNull();
		
	}
	
}
