package com.galeria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GaleriaApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(GaleriaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GaleriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Hola");
	}

}
