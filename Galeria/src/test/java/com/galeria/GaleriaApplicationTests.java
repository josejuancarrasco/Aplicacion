package com.galeria;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.galeria.controladores.ArticuloControlador;
import com.galeria.controladores.ArtistaControlador;
import com.galeria.controladores.ClienteControlador;
import com.galeria.entidades.Artista;
import com.galeria.entidades.Usuario;
import com.galeria.repositorios.IArticuloRepositorio;
import com.galeria.repositorios.IArtistaRepositorio;
import com.galeria.repositorios.IUsuarioRepositorio;

@SuppressWarnings("unused")
@SpringBootTest
class GaleriaApplicationTests {

	@Autowired
	private ArtistaControlador artistaControlador;

	@Autowired
	private ClienteControlador clienteControlador;

	@Autowired
	private ArticuloControlador articuloControlador;

	@Autowired
	private IUsuarioRepositorio usuarioRepo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void contextLoads() {

	}

	@Test
	public void crearUsuarioTest() {
		Usuario usuario = new Usuario();
		usuario.setNombre("Jose");
		usuario.setClave(encoder.encode("1234"));
		Usuario retorno = usuarioRepo.save(usuario);

		assertTrue(retorno.getClave().equals(usuario.getClave()));
	}

}
