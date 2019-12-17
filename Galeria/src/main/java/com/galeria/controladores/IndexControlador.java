package com.galeria.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class IndexControlador {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }
	
}
