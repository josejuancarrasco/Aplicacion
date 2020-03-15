package com.galeria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.galeria.entidades.Cliente;
import com.galeria.servicios.IClienteServicio;

@SpringBootTest
public class ClienteServicioTest {

	@Autowired
	private IClienteServicio clienteServicio;

	private static Cliente cliente;

	@BeforeAll
	public static void setUp() {
		cliente = new Cliente();

		cliente.setNombre("Jose Juan");
		cliente.setApellido_1("Carrasco");
	}

	@Test()
	public void nuevoCliente() {

		this.clienteServicio.add(cliente);

		assertThat(this.clienteServicio.getById(cliente.getId())).isNotNull();

	}

	@Test
	public void buscarPorId() {

		this.clienteServicio.add(cliente);

		assertThat(this.clienteServicio.getById(cliente.getId())).isNotNull();

	}

	@Test
	public void buscarPorNombre() {

		this.clienteServicio.add(cliente);

		List<Cliente> esperado = this.clienteServicio.buscarPorNombre("Jose Juan");

		assertThat(esperado.get(0).getNombre()).isEqualTo("Jose Juan");
	}

}