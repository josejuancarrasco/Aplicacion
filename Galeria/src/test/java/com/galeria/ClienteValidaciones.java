package com.galeria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.galeria.entidades.Cliente;

@SpringBootTest
public class ClienteValidaciones {

	@Autowired
	private static Validator validator;

	@BeforeAll
	public static void setUp() {
		// ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		// validator = factory.getValidator();

		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	public void validarCliente() {

		Cliente cliente = new Cliente();

		cliente.setNombre("Jose");
		// cliente.setApellido_1("Juan");

		Set<ConstraintViolation<Cliente>> violations = validator.validate(cliente);

		assertThat(violations).isEmpty();

	}

}
